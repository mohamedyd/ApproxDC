package qcri.ci.generaldatastructure.db;

import java.util.*;
public class Tuple {

	private ColumnMapping cm;
	private List<Cell> cells = new ArrayList<Cell>();
	
	public int tid;
	
	public Tuple(String[] values,ColumnMapping cm,int tid)
	{
		this.cm = cm;
		this.tid = tid;
		for(int i = 0 ; i < values.length; i++)
		{
			int typeId = cm.positionToType(i+1);
			String type;
			if (typeId == 0)
				type = "Integer";
			else if (typeId == 1) {
				type = "Double";
			}
			else {
				type = "String";
			}
			Cell cell = new Cell(type,values[i]);
			cells.add(cell);
		}
	}
	
	public Tuple(Tuple tuple)
	{
		this.cm = tuple.cm;
		for(Cell cell: tuple.cells)
		{
			this.cells.add(new Cell(cell));
		}
		this.tid = tuple.tid;
	}
	public List<Cell> getTuple()
	{
		return cells;
	}
	
	public int getNumCols()
	{
		return cells.size();
	}
	public Cell getCell(int col)
	{
		return cells.get(col);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		//sb.append("t" + tid + ":");
		for(int i = 0 ; i < cells.size(); i++)
		{
			sb.append(cells.get(i).toString());
			if(i != cells.size()-1)
				sb.append(",");
		}
		return new String(sb);
	}
	
}
