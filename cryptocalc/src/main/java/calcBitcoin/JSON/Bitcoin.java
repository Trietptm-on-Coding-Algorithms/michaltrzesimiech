package calcBitcoin.JSON;

import java.util.Date;

public class Bitcoin {

	String disclaimer;
	float rate_float;
	Date updated;
	protected bpi bpi;
	protected time time;

	public bpi getBpi() {
		return bpi;
	}

	public void setBpi(bpi bpi) {
		this.bpi = bpi;
	}

	public time getTime() {
		return time;
	}

	public void setTime(time time) {
		this.time = time;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public float getRate_float() {
		return rate_float;
	}

	public void setRate_float(float rate_float) {
		this.rate_float = rate_float;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;

	}

}