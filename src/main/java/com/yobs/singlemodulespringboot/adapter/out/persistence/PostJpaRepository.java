package com.yobs.singlemodulespringboot.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<PostJpaEntity, Long> {
}
