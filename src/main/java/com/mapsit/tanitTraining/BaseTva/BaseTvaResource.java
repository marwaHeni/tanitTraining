 package com.mapsit.tanitTraining.BaseTva;

import com.mapsit.tanitTraining.utility.*;
import com.mapsit.tanitTraining.errors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller
 */
@RestController
@RequestMapping("/api")
public class BaseTvaResource {

    private final Logger log = LoggerFactory.getLogger(BaseTvaResource.class);

    private static final String ENTITY_NAME = "mywaybaseBaseTva";

  //  @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BaseTvaService baseTvaService;

    public BaseTvaResource(BaseTvaService baseTvaService) {
        this.baseTvaService = baseTvaService;
    }

    /**
     * {@code POST  /bases-tva} : Create a new baseTva.
     *
     * @param baseTva the baseTva to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new baseTva, or with status {@code 400 (Bad Request)} if the baseTva has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bases-tva")
    public ResponseEntity<BaseTva> createBaseTva(@Valid @RequestBody BaseTva baseTva) throws URISyntaxException {
        log.debug("REST request to save BaseTva : {}", baseTva);
        if (baseTva.getId() != null) {
            throw new BadRequestAlertException("A new baseTva cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BaseTva result = baseTvaService.save(baseTva);


        return ResponseEntity.created(new URI("/api/bases-tva/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bases-tva} : Updates an existing baseTva.
     *
     * @param baseTva the baseTva to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated baseTva,
     * or with status {@code 400 (Bad Request)} if the baseTva is not valid,
     * or with status {@code 500 (Internal Server Error)} if the baseTva couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bases-tva")
    public ResponseEntity<BaseTva> updateBaseTva(@Valid @RequestBody BaseTva baseTva) throws URISyntaxException {
        log.debug("REST request to update BaseTva : {}", baseTva);
        if (baseTva.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BaseTva result = baseTvaService.save(baseTva);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, baseTva.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bases-tva} : get all the baseTvas.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of baseTva in body.
     */
    @GetMapping("/bases-tva")
    public ResponseEntity<List<BaseTva>> getAllBasesTva(Pageable pageable) {
        log.debug("REST request to get a page of BaseTvas");
        Page<BaseTva> page = baseTvaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /bases-tva/:id} : get the "id" baseTva.
     *
     * @param id the id of the baseTva to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the baseTva, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bases-tva/{id}")
    public ResponseEntity<BaseTva> getBaseTva(@PathVariable Long id) {
        log.debug("REST request to get BaseTva : {}", id);
        Optional<BaseTva> baseTva = baseTvaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(baseTva);
    }

    /**
     * {@code DELETE  /bases-tva/:id} : delete the "id" baseTva.
     *
     * @param id the id of the baseTva to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bases-tva/{id}")
    public ResponseEntity<Void> deleteBaseTva(@PathVariable Long id) {
        log.debug("REST request to delete BaseTva : {}", id);
        baseTvaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

}
