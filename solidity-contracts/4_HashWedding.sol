/// @title Hash-Wedding 0.01
/// @author Michal Trzesimiech

contract HashWedding {
    
	/*
	 * Marries two strings, places amount on common account
	 */
	
    event Print(string out);
    uint256 dowry;

    struct Groom {
        address groom_address;
        string groom_name;
    }

    struct Bride {
        address bride_address;
        string bride_name;        
    }

    struct Couple {
        string bride_name;
        string groom_name;
        string couple_address;
    }

    Bride public bride;
    Groom public groom;
    Couple public couple;

    function marry(string _groom, string _bride, address _bride_address, uint256 _dowry) public {

        groom = Groom(msg.sender, _groom);
        bride = Bride(_bride_address, _bride);
        dowry = _dowry;

        groom.groom_name = couple.groom_name;
        bride.bride_name = couple.bride_name;

        couple = Couple(couple.bride_name, couple.groom_name, couple.couple_address);

        Print(couple.bride_name);
        Print("and");
        Print(couple.groom_name);
        Print("I pronounce you a couple!");
        
        //couple.couple_address = generate a unique address, store dowry there
        
    }
}