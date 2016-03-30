contract ManipulateArray {
    uint[3] public data;
    event Print(uint256 out);
    event PrintString(string out);

    function assignDefault() {
        data[0] = 0;
        data[1] = 1;
        data[2] = 2;
        
    }

    function display(){
        Print(data[0]);
        Print(data[1]);
        Print(data[2]);

    }

    function modifyValues(uint256 x, uint256 y, uint256 z){
        data[0] = x;    
        data[1] = y;
        data[2] = z;
    }

    function checkIfDefault(){

        if (data[0] == 0 && data[1] == 1 && data[2] == 2){
            PrintString("Public array \"data\" stores its default values: ");
            Print(data[0]);
            Print(data[1]);
            Print(data[2]);
        } else {
            PrintString("You messed up with \"data\"'s default values. \nCurrent values are :");
            Print(data[0]);
            Print(data[1]);
            Print(data[2]);
        }

    }

    function clear(){
        //delete data[0];
		//delete data[1];
		//delete data[2];
        delete data; // clears the whole array
		
    }
    
}