package dp;
import dp.nonD;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class nonDtester{

	@Test
	public void in1() {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(0,8));
		assertEquals(2,nonD.longestSub(A, new ArrayList<Integer>(Collections.nCopies(A.size(), 0))));
	}
	
	@Test
	public void in2() {
		List<Integer> A = new ArrayList<Integer>(Arrays.asList(0,8,4,12,2,10,6,14,1,9));
		assertEquals(4,nonD.longestSub(A, new ArrayList<Integer>(Collections.nCopies(A.size(), 0))));
	}
	
}