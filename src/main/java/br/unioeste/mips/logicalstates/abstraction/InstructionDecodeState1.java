package br.unioeste.mips.logicalstates.abstraction;

import br.unioeste.mips.components.Datapath;
import br.unioeste.mips.logicalstates.Command;

public class InstructionDecodeState1 implements Command{

	private Datapath dataPath;
	
	public InstructionDecodeState1(Datapath dataPathParent)	{
		this.dataPath = dataPathParent;
	}
	
	
	public void performs() {

	}

}
