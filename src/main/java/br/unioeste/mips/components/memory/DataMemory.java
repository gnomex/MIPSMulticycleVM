package br.unioeste.mips.components.memory;

import java.util.ArrayList;

import br.unioeste.mips.common.exception.MemoryPermissionDenied;
import br.unioeste.mips.common.instruction.Instruction;

public class DataMemory {

	private Boolean MEMWRITE;
	private Boolean MEMREAD;

	private ArrayList<Integer> datamemory;
	private ArrayList<Instruction> instructions;

	private Integer addressIndex;

	public void setAdrress(Integer adrressIndex)	{
		this.addressIndex = adrressIndex;
	}

	
	
	public Instruction getInstruction()	throws Exception{

		try {

			if	(MEMWRITE == Boolean.TRUE)	{
				return instructions.get(this.addressIndex);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}

	public Integer getData()	throws Exception{

		try {

			if	(MEMWRITE == Boolean.TRUE)	{
				return datamemory.get(this.addressIndex);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMREAD is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException();
		}	
	}

	public void push(Instruction element)	throws Exception{

		try {

			if	(MEMREAD == Boolean.TRUE)	{
				instructions.add(this.addressIndex, element);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException(this.addressIndex);
		}

	}
	public void push(Integer element)	throws Exception{
		try {
			if	(MEMREAD == Boolean.TRUE)	{
				datamemory.add(this.addressIndex, element);
			} else	{
				throw new MemoryPermissionDenied("Flag MEMWRITE is not active!");
			}

		} catch (Exception e) {
			throw new ArrayIndexOutOfBoundsException(this.addressIndex);
		}
	}

}
