package gr.teachspot.library.persistence;

import gr.teachspot.library.domain.Attribute;
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
    public Attribute find(Long attributeId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("attribute_id", attributeId);
            return namedParameterJdbcTemplate.queryForObject(getSqlCommand("ATTRIBUTE.ID.SELECT"), source, getAttributeRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error during getting Attribute for [id:%s]",
                    attributeId), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attribute> get(Long userId) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("user_id", userId);
            return namedParameterJdbcTemplate.query(getSqlCommand("ATTRIBUTE.USER_ID.SELECT"), source, getAttributeRowMapper());
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while getting attributes for User[id:%s]",
                    userId), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long save(Attribute attribute) throws DataException{
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("name", attribute.getName());
            source.addValue("value", attribute.getValue());

            namedParameterJdbcTemplate.update(getSqlCommand("ATTRIBUTE.INSERT"), source, keyHolder);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while inserting a attribute",
                    attribute.toString()), ex);
        }

        return (Long)keyHolder.getKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(Attribute attribute) throws DataException {
        try {
            final MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("name", attribute.getName());
            source.addValue("value", attribute.getValue());
            source.addValue("attribute_id", attribute.getId());

            return namedParameterJdbcTemplate.update(getSqlCommand("ATTRIBUTE.UPDATE"), source);
        } catch (final Exception ex) {
            throw new DataException(String.format("Error while updating Attribute [id:%s]",
                    attribute.getId()), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Long attributeId) throws DataException {
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
                    attribute.setId(rs.getLong("attribute_id"));
                    attribute.setName(rs.getString("name"));
                    attribute.setValue(rs.getString("value"));
                    return attribute;
                };
    }
}
