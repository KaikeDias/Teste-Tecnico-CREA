package com.example.testetecnicocrea.modules.title.domain.repositories;

import com.example.testetecnicocrea.modules.title.domain.entities.Title;
import com.example.testetecnicocrea.modules.title.domain.entities.TitleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public class TitleRepositoryImp implements TitleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(TitleDTO titleDTO){
        String sql = "INSERT INTO TITLE (DESCRIPTION) VALUES (?)";

        String description = titleDTO.description();

        return jdbcTemplate.update(sql, description);
    }

    @Override
    public int update(Title title) {
        String sql = "UPDATE TITLE SET DESCRIPTION=? WHERE ID=?";

        return jdbcTemplate.update(sql, title.getDescription(), title.getId());
    }

    @Override
    public Title findById(int id) {
        String sql = "SELECT * FROM TITLE WHERE ID = ?";

        RowMapper<Title> mapper = new RowMapper<Title>() {
            @Override
            public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
                Title title = new Title();
                title.setId(rs.getInt("ID"));
                title.setDescription(rs.getString("DESCRIPTION"));
                return title;
            }
        };

        Title title = jdbcTemplate.queryForObject(sql, mapper, id);

        return title;
    }

    @Override
    public int deleteById(int id) {
       return jdbcTemplate.update("DELETE FROM TITLE WHERE ID=?", id);
    }

    @Override
    public List<Title> findAll() {
        String sql = "SELECT * FROM TITLE";

        RowMapper<Title> mapper = new RowMapper<Title>() {
            @Override
            public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
                Title title = new Title();
                title.setId(rs.getInt("ID"));
                title.setDescription(rs.getString("DESCRIPTION"));
                return title;
            }
        };

        List<Title> titles = jdbcTemplate.query(sql, mapper);

        return titles;
    }

    @Override
    public int deleteAll() {
        String sql = "DELETE FROM TITLE";

        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Title> findByProfessionalId(int id) {
        String sql = "SELECT TITLE.ID, TITLE.DESCRIPTION FROM TITLE JOIN PROFESSIONAL_TITLE ON TITLE.ID = PROFESSIONAL_TITLE.TITLE_ID WHERE PROFESSIONAL_TITLE.PROFESSIONAL_ID = ?";

        RowMapper<Title> mapper = new RowMapper<Title>() {
            @Override
            public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
                Title title = new Title();
                title.setId(rs.getInt("ID"));
                title.setDescription(rs.getString("DESCRIPTION"));
                return title;
            }
        };

        List<Title> titles = jdbcTemplate.query(sql, mapper, id);

        return titles;
    }
}
