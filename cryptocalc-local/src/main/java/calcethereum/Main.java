/*
 * Calculate PLN worth of owned ETH based on current ETH/EUR rate.
 */

package calcethereum;

import java.io.IOException;

public class Main implements Calculate {

	public static void main(String[] args) throws IOException {

		Calculate.calculate(
				38.34702, 	// owned ether
				1516.85, 	// initial investment in PLN
				4.37); 		// rate EUR/PLN

	}

}