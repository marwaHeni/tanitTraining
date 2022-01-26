package com.mapsit.tanitTraining.BaseTva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation
 */
@Service
@Transactional
public class BaseTvaService {

    private final Logger log = LoggerFactory.getLogger(BaseTvaService.class);

    private final BaseTvaRepository baseTvaRepository;

    public BaseTvaService(BaseTvaRepository baseTvaRepository) {
        this.baseTvaRepository = baseTvaRepository;
    }

    /**
     * Save a baseTva.
     *
     * @param baseTva the entity to save.
     * @return the persisted entity.
     */
    public BaseTva save(BaseTva baseTva) {
        log.debug("Request to save BaseTva : {}", baseTva);
        return baseTvaRepository.save(baseTva);
    }

    /**
     * Get all the baseTvas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<BaseTva> findAll(Pageable pageable) {
        log.debug("Request to get all BaseTvas");
        return baseTvaRepository.findAll(pageable);
    }


    /**
     * Get one baseTva by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<BaseTva> findOne(Long id) {
        log.debug("Request to get BaseTva : {}", id);
        return baseTvaRepository.findById(id);
    }

    /**
     * Delete the baseTva by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete BaseTva : {}", id);
        baseTvaRepository.deleteById(id);
    }



}
