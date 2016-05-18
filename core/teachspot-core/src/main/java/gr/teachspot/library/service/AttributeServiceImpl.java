package gr.teachspot.library.service;


import gr.teachspot.library.domain.Attribute;
import gr.teachspot.library.persistence.AttributeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Attribute service impl contains all the business methods related to a {@link gr.teachspot.library.domain.Attribute}.
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    /**
     * Logger to be used
     */
    private final static Logger LOG = LoggerFactory.getLogger(AttributeServiceImpl.class);


    /**
     * The Attribute Repository.
     */
    @Autowired
    private AttributeRepository attributeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Attribute find(Long attributeId) {
        return attributeRepository.find(attributeId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attribute> get(Long userId) {
        return attributeRepository.get(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long save(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(Attribute attribute) {
        return attributeRepository.update(attribute);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Long attributeId) {
        return attributeRepository.delete(attributeId);
    }
}
