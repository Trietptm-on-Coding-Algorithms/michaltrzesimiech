/*
 * Calculate PLN worth of owned ETH based on current ETH/EUR rate.
 */

package calcethereum;

import java.io.IOException;

public class Main implements Calculate {

	public static void main(String[] args) throws IOException {

		// Enter values (ether owned, initial investment in PLN, rate EUR/PLN)
		Calculate.calculate(38.34702, 1516.85, 4.37);

	}

}