package org.djvmil.em.backend.core.repository;

import org.djvmil.em.backend.core.entity.CommunityMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommunityMemberShipRepository extends JpaRepository<CommunityMembership, Long> {
}
