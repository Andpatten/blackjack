package edu.cnm.deepdive.blackjack.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.blackjack.model.entity.Hand;
import edu.cnm.deepdive.blackjack.model.entity.Round;
import java.util.List;

public class RoundWithDetails extends Round {

  @Relation(parentColumn = "round_id", entity = Hand.class, entityColumn = "round_id")
  private List<HandWithCards> hands;

  public List<HandWithCards> getHands() {
    return hands;
  }

  public void setHands(List<HandWithCards> hands) {
    this.hands = hands;
  }
}
