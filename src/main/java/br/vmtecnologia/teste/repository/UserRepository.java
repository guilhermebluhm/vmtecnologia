package br.vmtecnologia.teste.repository;

import br.vmtecnologia.teste.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query(value = "select t from user us where lower(us.name) like lower(concat('%', :title, '%'))", nativeQuery = true)
    Page<User> findByUserWithPageable(String title, Pageable pageable);

    @Query(value = "select us.name, us.email from tbl_user us where us.id = :id", nativeQuery = true)
    User findByIdWithJPQL(@Param("id") String id);
}
