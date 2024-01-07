package com.springboot.bookreviewsystem.project.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.exceptions.SequenceException;

@Service
public class SequenceGenerator {

	@Autowired
	private  MongoOperations mongoOperation;
	
	public long getNextSequenceId(String key) throws SequenceException  {
		 Query query = new Query(Criteria.where("_id").is(key));
		 
		//increase sequence id by 1
		  Update update = new Update();
		  update.inc("sequence", 1);

		  //return new increased id
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true).upsert(true);
		//this is the magic happened.
		  UserSequence seqId = mongoOperation.findAndModify(query, update, options, UserSequence.class);

		  //if no id, throws SequenceException
	          //optional, just a way to tell user when the sequence id is failed to generate.
		  if (seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : " + key);
		  }

		  return seqId.getSequence();

	}
}
