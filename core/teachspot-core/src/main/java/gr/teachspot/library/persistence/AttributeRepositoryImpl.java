package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;
import gr.teachspot.library.domain.Lesson;
import gr.teachspot.library.domain.Profile;
import gr.teachspot.library.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    @Override
    public Long save(Attribute attribute) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("value", attribute);

            namedParameterJdbcTemplate.update(getSqlCommand("ATTRIBUTE.INSERT"), source, keyHolder);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while inserting a attribute",
                    attribute.toString()), ex);
        }

        return (Long)keyHolder.getKey();
    }

    @Override
    public int update(Attribute attribute) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("name", profile.getType().toString());
            source.addValue("attribute_id", attribute.getId());
            source.addValue("value", attribute);

            return namedParameterJdbcTemplate.update(getSqlCommand("ATTRIBUTE.UPDATE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while updating Profile [id:%s]",
                    profile.getId()), ex);
        }
    }

    @Override
    public int delete(Long attributeId) {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("attribute_id", attributeId);

            return namedParameterJdbcTemplate.update(getSqlCommand("ATTRIBUTE.DELETE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during deleting Attribute [id:%s]",
                    attributeId), ex);
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
