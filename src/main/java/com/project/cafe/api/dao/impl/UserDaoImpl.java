package com.project.cafe.api.dao.impl;

import com.project.cafe.api.dao.AbstractDao;
import com.project.cafe.api.dao.IUserDao;
import com.project.cafe.api.model.UserTB;
import com.project.cafe.api.util.ConstantsValidations;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<UserTB> implements IUserDao {

  @PersistenceContext(unitName = "default")
  private EntityManager em;

  public List<UserTB> find() {
    return super.findAll();
  }

  public UserTB findById(Long id) {
    if (id == null) {
      return null;
    }
    return super.findOne(id);
  }

  public Optional<UserTB> findByName(String name) {
    // PARAMETERS
    Map<String, Object> pamameters = new HashMap<>();

    // QUERY
    StringBuilder JPQL = new StringBuilder(
      "SELECT t FROM UserTB t WHERE 1 = 1 "
    );
    // WHERE
    if (!StringUtils.isBlank(name)) {
      JPQL.append("AND t.name = :NAME ");
      pamameters.put("NAME", name);
    }
    // Q. Order By
    JPQL.append(" ORDER BY t.id DESC");
    // END QUERY

    TypedQuery<UserTB> query = em.createQuery(JPQL.toString(), UserTB.class);
    pamameters.forEach((k, v) -> query.setParameter(k, v));

    List<UserTB> result = query.getResultList();

    return Optional.ofNullable(
      result != null && !result.isEmpty() ? result.get(0) : null
    );
  }

  @Override
  public Optional<UserTB> findByMail(String mail) {
    // PARAMETERS
    Map<String, Object> pamameters = new HashMap<>();

    // QUERY
    StringBuilder JPQL = new StringBuilder(
      "SELECT t FROM UserTB t WHERE 1 = 1 "
    );
    // WHERE
    if (!StringUtils.isBlank(mail)) {
      JPQL.append("AND t.mail = :MAIL ");
      pamameters.put("MAIL", mail);
    }
    // Q. Order By
    JPQL.append(" ORDER BY t.id DESC");
    // END QUERY

    TypedQuery<UserTB> query = em.createQuery(JPQL.toString(), UserTB.class);
    pamameters.forEach((k, v) -> query.setParameter(k, v));

    List<UserTB> result = query.getResultList();

    return Optional.ofNullable(
      result != null && !result.isEmpty() ? result.get(0) : null
    );
  }

  @Override
  public UserTB createUser(UserTB entity) {
    setDefaultValues(entity, ConstantsValidations.PHASE_CREATE);
    super.create(entity);

    return entity;
  }

  @Override
  public UserTB updateUser(UserTB entity) {
    setDefaultValues(entity, ConstantsValidations.PHASE_UPDATE);
    super.update(entity);

    return entity;
  }

  private void setDefaultValues(UserTB entity, String phase) {
    LocalDateTime now = LocalDateTime.now();
    if (ConstantsValidations.PHASE_CREATE.equalsIgnoreCase(phase)) {
      entity.setCreateDate(now);
      entity.setCreateUser("SYSTEM");
      entity.setActive(true);
      entity.setId(null);
    }
    entity.setUpdateDate(now);
    entity.setUpdateUser("SYSTEM");
  }
}
