package org.ecomComparators;

import java.util.Comparator;

import org.pojos.OutputPojo;

public class PriceComparator implements Comparator<OutputPojo>{

	@Override
	public int compare(OutputPojo o1, OutputPojo o2) {
		
		if(o1.getPrice()<o2.getPrice())
			return -1;
		else if(o1.getPrice()>o2.getPrice())
			return 1;
		else
			return 0;
	}

}
