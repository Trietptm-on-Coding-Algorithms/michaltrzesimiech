package calcEthereum;

public class Ethereum {

	protected String timestamp;
	protected boolean success;
	protected String error;
	
	//
	
	protected ticker ticker;
	
	public ticker getEthereumTicker() {
		return ticker;
	}

	public void setEthereumTicker(ticker ticker) {
		this.ticker = ticker;
	}
	
	//
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}


}