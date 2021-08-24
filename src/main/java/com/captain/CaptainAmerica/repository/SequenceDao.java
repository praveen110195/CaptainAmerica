package com.captain.CaptainAmerica.repository;


import com.captain.CaptainAmerica.exception.SequenceException;

public interface SequenceDao {

    long getNextSequenceId(String key, String sequenceName) throws SequenceException;

}