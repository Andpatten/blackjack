package edu.cnm.deepdive.blackjack.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import edu.cnm.deepdive.blackjack.model.entity.Round;
import edu.cnm.deepdive.blackjack.model.pojo.RoundWithDetails;
import java.util.List;

@Dao
public interface RoundDao {

  @Insert
  long insert(Round round);

  @Query("SELECT * FROM Round ORDER BY created ASC")
  LiveData<List<Round>> getAll();

  @Query("SELECT * FROM Round WHERE shoe_id = :shoeId ORDER BY created ASC")
  LiveData<List<Round>> getByShoeId(long shoeId);

  @Query("SELECT * FROM Round WHERE round_id = :roundId")
  LiveData<Round> getByRoundId(long roundId);
  
  @Transaction
  @Query("SELECT * FROM Round WHERE round_id = :roundId")
  LiveData<RoundWithDetails> getRoundWithDetails(long roundId);
}
