package io.halkyon.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

@Entity
public class Claim extends PanacheEntity {

    @FormParam
	public String name;
    @FormParam
    public String serviceRequested;
    @FormParam
    public String description;
    @FormParam
    public String status;
    @FormParam
    public String owner;
    @FormParam
    public Date created;

    public static Claim findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Claim> listAll() {
        return findAll(Sort.ascending("name")).list();
    }
}
