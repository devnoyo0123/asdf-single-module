package com.yobs.singlemodulespringboot.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<PostJpaEntity, Long> {
}
