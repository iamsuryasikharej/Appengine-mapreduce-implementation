package com.surya.mappers;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.mapreduce.MapJob;
import com.google.appengine.tools.mapreduce.MapOnlyMapper;
import com.google.appengine.tools.mapreduce.MapSettings;
import com.google.appengine.tools.mapreduce.MapSpecification;
import com.google.appengine.tools.mapreduce.inputs.ConsecutiveLongInput;
import com.google.appengine.tools.mapreduce.inputs.RandomLongInput;
import com.google.appengine.tools.mapreduce.outputs.DatastoreOutput;
import com.google.appengine.tools.mapreduce.outputs.NoOutput;

public class Runner {
	 private static final long serialVersionUID = 6725038763886885189L;
	  

	  private MapSpecification<Long, Entity, Void> getCreationJobSpec(int bytesPerEntity, int entities,
		      int shardCount) {
		    // [START mapSpec]
		  MapSpecification<Long, Entity, Void> spec = new MapSpecification.Builder<>(
			        new RandomLongInput(1000, 10),
			        new EntityCreator("", 12),
			        new DatastoreOutput())
			        .setJobName("Create MapReduce entities")
			        .build();
		  return spec;
		  }
	  private MapSettings getSettings() {
		    // [START mapSettings]
		    MapSettings settings = new MapSettings.Builder()
		        .setWorkerQueueName("mapreduce-workers")
		        .build();
		    // [END mapSettings]
		    return settings;
		  }
	  public void start()
	  {
		  String id = MapJob.start(getCreationJobSpec(0, 0,0),getSettings());
	  }
}
