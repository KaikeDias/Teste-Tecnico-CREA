package com.example.testetecnicocrea.modules.professional.domain.repositories;

import com.example.testetecnicocrea.common.utils.CodeGenerator;
import com.example.testetecnicocrea.modules.professional.domain.entities.Professional;
import com.example.testetecnicocrea.modules.professional.domain.entities.ProfessionalDTO;
import com.example.testetecnicocrea.modules.professional.domain.entities.ProfessionalType;
import com.example.testetecnicocrea.modules.professional.domain.entities.RegistrationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProfessionalRepositoryImp implements ProfessionalRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ProfessionalDTO professionalDTO) {
        String sql = "INSERT INTO PROFESSIONAL (NAME, EMAIL, PASSWORD, BIRTH_DATE, PHONE_NUMBER, REGISTER_DATE," +
                " professional_type, visa_date" +
                ")" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        String name = professionalDTO.name();
        String email = professionalDTO.email();
        String password = professionalDTO.password();
        LocalDate birthDate = professionalDTO.birthDate();
        String phoneNumber = professionalDTO.phoneNumber();
        LocalDateTime registerDate = LocalDateTime.now();
        ProfessionalType professionalType = professionalDTO.professionalType();
        LocalDateTime visaDate = null;
        if (professionalType == ProfessionalType.VISADO) {
            visaDate = LocalDateTime.now();
        }

        return jdbcTemplate.update(sql, name, email, password, birthDate, phoneNumber, registerDate, professionalType.toString()
                , visaDate);
    }

    @Override
    public int update(Professional professional) {
        String sql = "UPDATE PROFESSIONAL SET NAME=?, EMAIL=?, PASSWORD=?, BIRTH_DATE=?, " +
                "REGISTER_DATE=?, PHONE_NUMBER=?, REGISTRATION_STATUS=? WHERE ID=?";

        String name = professional.getName();
        String email = professional.getEmail();
        String password = professional.getPassword();
        LocalDate birthDate = professional.getBirthDate();
        LocalDateTime registerDate = professional.getRegisterDate();
        String phoneNumber = professional.getPhoneNumber();
        RegistrationStatus status = professional.getRegistrationStatus();
        int id = professional.getId();

        return jdbcTemplate.update(sql, name, email, password, birthDate, registerDate, phoneNumber, status.toString(), id);
    }

    @Override
    public Professional findById(int id) {
        String sql = "SELECT * FROM PROFESSIONAL WHERE ID=?";

        RowMapper<Professional> mapper = new RowMapper<Professional>() {
            @Override
            public Professional mapRow(ResultSet rs, int rowNum) throws SQLException {
                Professional professional = new Professional();
                professional.setId(rs.getInt("ID"));
                professional.setName(rs.getString("NAME"));
                professional.setEmail(rs.getString("EMAIL"));
                professional.setBirthDate(rs.getDate("BIRTH_DATE").toLocalDate());
                professional.setRegisterDate(rs.getTimestamp("REGISTER_DATE").toLocalDateTime());
                professional.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                professional.setCode(rs.getString("CODE"));
                String statusString = rs.getString("REGISTRATION_STATUS");
                if(statusString != null) {
                    professional.setRegistrationStatus(RegistrationStatus.valueOf(statusString));
                } else {
                    professional.setRegistrationStatus(null);
                }
                String professionalTypeString = rs.getString("PROFESSIONAL_TYPE");
                if (professionalTypeString != null) {
                    professional.setProfessionalType(ProfessionalType.valueOf(professionalTypeString));
                } else {
                    professional.setProfessionalType(null);
                }
                var visaDate = rs.getTimestamp("VISA_DATE");
                if(visaDate != null) {
                    professional.setVisaDate(visaDate.toLocalDateTime());
                } else {
                    professional.setVisaDate(null);
                }


                return professional;
            }
        };

        Professional professional = jdbcTemplate.queryForObject(sql, mapper, id);

        return professional;
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM professional WHERE ID=?", id);
    }

    @Override
    public List<Professional> findAll() {
        String sql = "SELECT * FROM PROFESSIONAL";

        RowMapper<Professional> mapper = new RowMapper<Professional>() {
            @Override
            public Professional mapRow(ResultSet rs, int rowNum) throws SQLException {
                Professional professional = new Professional();
                professional.setId(rs.getInt("ID"));
                professional.setName(rs.getString("NAME"));
                professional.setEmail(rs.getString("EMAIL"));
                professional.setBirthDate(rs.getDate("BIRTH_DATE").toLocalDate());
                professional.setRegisterDate(rs.getTimestamp("REGISTER_DATE").toLocalDateTime());
                professional.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                professional.setCode(rs.getString("CODE"));
                String statusString = rs.getString("REGISTRATION_STATUS");
                if(statusString != null) {
                    professional.setRegistrationStatus(RegistrationStatus.valueOf(statusString));
                } else {
                    professional.setRegistrationStatus(null);
                }
                String professionalTypeString = rs.getString("PROFESSIONAL_TYPE");
                if (professionalTypeString != null) {
                    professional.setProfessionalType(ProfessionalType.valueOf(professionalTypeString));
                } else {
                    professional.setProfessionalType(null);
                }
                var visaDate = rs.getTimestamp("VISA_DATE");
                if(visaDate != null) {
                    professional.setVisaDate(visaDate.toLocalDateTime());
                } else {
                    professional.setVisaDate(null);
                }


                return professional;
            }
        };

        List<Professional> professionals = jdbcTemplate.query(sql, mapper);

        return professionals;
    }



    @Override
    public int deleteAll() {
        String sql = "DELETE FROM professional";

        return jdbcTemplate.update(sql);
    }

    @Override
    public void addTitle(int professionalId, int titleId) {
        String sqlInsert = "INSERT INTO PROFESSIONAL_TITLE (PROFESSIONAL_ID, TITLE_ID) VALUES (?, ?)";

        jdbcTemplate.update(sqlInsert, professionalId, titleId);

        Professional professional = findById(professionalId);
        if(professional.getRegistrationStatus() != RegistrationStatus.ATIVO) {
            String sqlUpdate = "UPDATE PROFESSIONAL SET registration_status=? WHERE ID=?";
            RegistrationStatus status = RegistrationStatus.ATIVO;

            jdbcTemplate.update(sqlUpdate, status.toString(), professionalId);
            if(professional.getCode() == null) {
                String sqlAddCode = "UPDATE PROFESSIONAL SET code=? WHERE ID=?";
                String code = CodeGenerator.generateCode();

                jdbcTemplate.update(sqlAddCode, code, professionalId);
            }
        }
    }

    @Override
    public void updateProfessionalTypeToVisado(int professionalId, LocalDateTime visaDate) {
        String sql = "UPDATE PROFESSIONAL SET PROFESSIONAL_TYPE=?, VISA_DATE=? WHERE ID=?";

        jdbcTemplate.update(sql, ProfessionalType.VISADO.toString(), visaDate, professionalId);
    }

    @Override
    public void removeTitleFromProfessional(int titleId, int professionalId) {
        String sql = "DELETE FROM PROFESSIONAL_TITLE WHERE PROFESSIONAL_ID=? AND TITLE_ID=?";

        jdbcTemplate.update(sql, professionalId, titleId);
    }

    @Override
    public void updateProfessionalStatus(int id, RegistrationStatus status) {
        String sql = "UPDATE PROFESSIONAL SET REGISTRATION_STATUS=? WHERE ID=?";

        jdbcTemplate.update(sql, status.toString(), id);
    }
}
