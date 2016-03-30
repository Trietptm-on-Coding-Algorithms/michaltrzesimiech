/// @title Timed Contract
/// @author Michal Trzesimiech

contract TimedContract1 {
    
    /*
     * Costs 4661 gas
     */
    
    address creator = msg.sender;
    event PrintString(string out);
    event Print(uint256 out);

    function timedKill(uint _time) {

    PrintString("Bye, bye in: ");
    Print(_time);
    
        if (now <= _time) {
            PrintString("Bye, bye");
            if (msg.sender == creator)
                suicide(creator);
                
        }
    }
}

contract TimedContract2 {

    /*
     * Costs 206158408936 gas
     */

    address creator = msg.sender;
    event PrintString(string out);
    event Print(uint256 out);

    modifier onlyAfter(uint _time) { if (now <= _time) throw; _}    

    function timedKill() onlyAfter(5 seconds) {

        PrintString("Bye, bye");
        if (msg.sender == creator)
            suicide(creator);

    }
}