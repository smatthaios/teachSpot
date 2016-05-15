package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;
import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Attribute repository impl contains all {@link Attribute} related database actions.
 */
@Repository
public class AttributeRepositoryImpl extends AbstractRepository implements AttributeRepository {

    /**
     * {@link NamedParameterJdbcTemplate}
     */
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public Attribute find(Long attributeId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", attributeId);
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("ATTRIBUTE.ID.SELECT"), source, getAttributeRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Attribute for [id:%s]",
                    attributeId), ex);
        }
    }

    @Override
    public List<Attribute> get(Long userId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", userId);
            return namedParameterJdbcTemplate.query(getSqlCommand("ATTRIBUTE.USER_ID.SELECT"), source, getAttributeRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Attribute for [id:%s]",
                    userId), ex);
        }
    }

    private RowMapper<Attribute> getAttributeRowMapper() {
        return (rs, rowNum) -> {
                    Attribute attribute = new Attribute();
                    attribute.setId(rs.getLong("user_attributes_id"));
                    attribute.setName(rs.getString("name"));
                    attribute.setValue(rs.getString("value"));
                    return attribute;
                };
    }
}
