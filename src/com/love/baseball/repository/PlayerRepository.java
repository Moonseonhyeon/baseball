package com.love.baseball.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.love.baseball.db.DBConn;
import com.love.baseball.dto.PlayerListResponseDto;
import com.love.baseball.model.Player;
import com.love.baseball.model.Team;


public class PlayerRepository {
	
	private static final String TAG = "PlayerRepository : ";
	private static PlayerRepository instance = new PlayerRepository();
	public PlayerRepository() {	}
	public static PlayerRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<PlayerListResponseDto> findByTeamId(int teamId) {
		StringBuilder sb = new StringBuilder();		
		sb.append("SELECT p.playerId, p.name, t.teamId, t.teamName ");
		sb.append("FROM team t INNER JOIN player p ");
		sb.append("ON t.teamid = p.teamid ");
		sb.append("WHERE t.teamId = ? ");

		final String SQL = sb.toString();
		List<PlayerListResponseDto> dtos = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, teamId);

			// while돌려서 rs오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PlayerListResponseDto dto = PlayerListResponseDto.builder()
						.playerId(rs.getInt(1))
						.name(rs.getString(2))
						.build();
				dtos.add(dto);
			}
			return dtos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByTeamId(int teamId) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	
	public Player findByPlayerId(int playerId) {		
		final String SQL = "SELECT playerId, name, position FROM player WHERE playerId = ?";
		Player player = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, playerId);

			// while돌려서 rs오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				player = Player.builder()
						.playerId(rs.getInt("playerId"))
						.name(rs.getString("name"))
						.position(rs.getString("position"))
						.build();			
			}
			
			return player;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByTeamId(int teamId) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}

		return null;
	}
	
	
	
}
