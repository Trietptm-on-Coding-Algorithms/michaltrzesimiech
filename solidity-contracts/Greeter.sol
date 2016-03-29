contract greeter {
    address creator = msg.sender;
    string greeting;
    
    function greeter(string _greeting) public {
        greeting = _greeting;
    }

    function kill()   { 
        if (msg.sender == creator)
            suicide(creator);  // kills this contract and sends remaining funds back to creator
    }

    /* main function */
    function greet() constant returns (string) {
        return greeting;
    }

}
