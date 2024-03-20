package org.djvmil.em.backend.core.repository.db;
/*
import org.djvmil.em.core.entity.User;
import org.djvmil.em.core.repository.IAuthentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
//@Component
public class AuthentificationDBRepository implements IAuthentificationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(String login, String password){

        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?", new Object[]{login, password},
                ((rs, rowNum) -> new User(rs.getLong("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("USER_ROLE"),
                        rs.getString("GENRE"),
                        rs.getString("COUNTRY"),
                        rs.getString("PHONE_NUMBER"),
                        rs.getString("EMAIL"),
                        rs.getString("PASSWORD"),
                        rs.getString("BIRTHDATE"))));
    }

    @Override
    public User register(User user){

        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO USER (FIRSTNAME, LASTNAME, USER_ROLE, GENRE, COUNTRY, PHONE_NUMBER, EMAIL, PASSWORD, BIRTHDATE) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getGenre());
            ps.setString(5, user.getCountry());
            ps.setString(6, user.getPhoneNumber());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getPasswors());
            ps.setString(9, user.getBirthDate());

            return ps;
        }, kh);

        user.setId((Long) kh.getKey());

        return user;
    }

    @Override
    public List<User> list() {
        return jdbcTemplate.query("SELECT * FROM USER", ((rs, rowNum) -> new User(rs.getLong("ID"),
                rs.getString("FIRSTNAME"),
                rs.getString("LASTNAME"),
                rs.getString("USER_ROLE"),
                rs.getString("GENRE"),
                rs.getString("COUNTRY"),
                rs.getString("PHONE_NUMBER"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("BIRTHDATE"))));
    }

    @Override
    public User getById(Long userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID=? ", new Object[]{userId}, ((rs, rowNum) -> new User(rs.getLong("ID"),
                rs.getString("FIRSTNAME"),
                rs.getString("LASTNAME"),
                rs.getString("USER_ROLE"),
                rs.getString("GENRE"),
                rs.getString("COUNTRY"),
                rs.getString("PHONE_NUMBER"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("BIRTHDATE"))));
    }
}
*/