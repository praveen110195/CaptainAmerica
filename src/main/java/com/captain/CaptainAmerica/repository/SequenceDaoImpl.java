package com.captain.CaptainAmerica.repository;

import com.captain.CaptainAmerica.exception.SequenceException;
import com.captain.CaptainAmerica.model.InvoiceSequenceId;
import com.captain.CaptainAmerica.model.SequenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDaoImpl implements SequenceDao {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public long getNextSequenceId(String key, String sequenceName) throws SequenceException {
        
      //get sequence id
      Query query = new Query(Criteria.where("_id").is(key));

      //increase sequence id by 1
      Update update = new Update();
      update.inc("seq", 1);

      //return new increased id
      FindAndModifyOptions options = new FindAndModifyOptions();
      options.returnNew(true);

      if(sequenceName.equals("Customer")) {
          //this is the magic happened.
          SequenceId seqId =
                  mongoOperation.findAndModify(query, update, options, SequenceId.class);

          //if no id, throws SequenceException
          //optional, just a way to tell user when the sequence id is failed to generate.
          if (seqId == null) {
              throw new SequenceException("Unable to get sequence id for key : " + key);
          }

          return seqId.getSeq();
      } else {
          //this is the magic happened.
          InvoiceSequenceId seqId =
                  mongoOperation.findAndModify(query, update, options, InvoiceSequenceId.class);

          //if no id, throws SequenceException
          //optional, just a way to tell user when the sequence id is failed to generate.
          if (seqId == null) {
              throw new SequenceException("Unable to get sequence id for key : " + key);
          }

          return seqId.getSeq();
      }

    }

}