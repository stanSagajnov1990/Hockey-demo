package com.stanislav.model;

public enum PlayerType {
	PLAYER('P'), GOALIE('G');
	
	private final char code;
	
	PlayerType(char code) {
		this.code = code;
	}
	
	public static PlayerType fromCode(char code) {
        if ( code == 'P' || code == 'p' ) {
            return PLAYER;
        }
        if ( code == 'G' || code == 'g' ) {
            return GOALIE;
        }
        throw new UnsupportedOperationException(
            "The code " + code + " is not supported!"
        );
    }
	
	public char getCode(){
		return this.code;
	}
	
}
