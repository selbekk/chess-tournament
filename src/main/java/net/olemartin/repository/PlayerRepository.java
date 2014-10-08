package net.olemartin.repository;

import net.olemartin.business.Player;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends GraphRepository<Player> {

    @Query("MATCH (player) <-[:PLAYER]- (match:Match), " +
            "(match) -[:LOOSER]-> (otherPlayer:Player) " +
            "WHERE id(player)={who} " +
            "RETURN otherPlayer")
    public Iterable<Player> findOpponentsPlayerBeat(@Param("who") long player);

    @Query("MATCH (player) <-[:PLAYER]- (match:Match {result:\"REMIS\"}), " +
            "(match) -[:PLAYER]-> (otherPlayer:Player) " +
            "WHERE id(player)={who} " +
            "RETURN otherPlayer")
    public Iterable<Player> findOpponentsRemis(@Param("who") long player);

}