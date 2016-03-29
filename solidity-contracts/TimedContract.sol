/* 
 * IN PROGRESS 
 */

contract TimedContract {
    address creator = msg.sender;
    event aborted();
    event PrintString(string out);
    event Print(uint256 out);
    uint _time;
    
    modifier onlyAfter(uint _time) { if (now <= _time) throw; aborted();}    

    function TimedKill(uint time){

    PrintString("Bye, bye in: ");
    Print(_time);
    
        if (now <= _time) {
            PrintString("Bye, bye");
            if (msg.sender == creator)
                suicide(creator);
            aborted();

        }
    }
}