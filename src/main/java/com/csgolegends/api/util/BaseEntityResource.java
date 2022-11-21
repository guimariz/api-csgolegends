package com.csgolegends.api.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseEntityResource {


    @PersistenceContext
    public EntityManager em = this.em;
}
