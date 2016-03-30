/// @title Greeter
/// @author Michal Trzesimiech

    /*
     * Greets with custom string greeting, then kills msg.sender
     */

contract greeter {
    address creator = msg.sender;
    string greeting;
    
    function greeter(string _greeting) public {greeting = _greeting;}
    function greet() constant returns (string) {return greeting; if(creator==msg.sender) suicide(creator);}
    
}