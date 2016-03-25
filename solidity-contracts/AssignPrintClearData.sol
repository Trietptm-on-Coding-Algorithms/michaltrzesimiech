contract AssignPrintClearData {

    uint[3] public data;
    event Print(uint256 out);

    function assign() {
        data[0] = 0;
        data[1] = 1;
        data[2] = 2;
        
    }

    function print(){
        Print(data[0]);
        Print(data[1]);
        Print(data[2]);

    }

    function clear(){
        //delete data[0];
	//delete data[1];
	//delete data[2];
        delete data; // clears the whole array
		
    }
    
}
