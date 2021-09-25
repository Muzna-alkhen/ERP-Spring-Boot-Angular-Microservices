package com.programming.techie.hrservice.repository;


import com.programming.techie.hrservice.model.Leave_status;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Leave_statusRepository implements JpaRepository<Leave_status, Long> {


    @Override
    public List<Leave_status> findAll() {
        return null;
    }

    @Override
    public List<Leave_status> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Leave_status> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Leave_status> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Leave_status leave_status) {

    }

    @Override
    public void deleteAll(Iterable<? extends Leave_status> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Leave_status> S save(S s) {
        return null;
    }

    @Override
    public <S extends Leave_status> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Leave_status> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Leave_status> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Leave_status> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Leave_status getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Leave_status> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Leave_status> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Leave_status> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Leave_status> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Leave_status> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Leave_status> boolean exists(Example<S> example) {
        return false;
    }
}
