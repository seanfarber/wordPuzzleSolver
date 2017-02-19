/** 
 * Sean Farber 11/10/16
 * Solves the word search puzzle at the following url:
 * WordPuzzel http://thewordsearch.com/puzzle/1707/frozen/
 * Future update to read letters in the image.
 */
public class WordPuzzle {

	public static void main(String[] args) {
		
		
		char [][] puzzle =  {{'N', 'E', 'K', 'E', 'S', 'N', 'E', 'V', 'S', 'S', 'N', 'U', 'E', 'S'},
				             {'T', 'N', 'I', 'C', 'E', 'S', 'I', 'E', 'K', 'G', 'E', 'L', 'E', 'W'},
				             {'P', 'A', 'S', 'A', 'U', 'N', 'A', 'K', 'E', 'N', 'R', 'S', 'L', 'E'},
				             {'O', 'M', 'S', 'E', 'N', 'T', 'R', 'O', 'O', 'O', 'F', 'V', 'T', 'A'},
				             {'W', 'W', 'F', 'I', 'S', 'I', 'F', 'N', 'I', 'S', 'A', 'H', 'S', 'R'},
				             {'E', 'O', 'A', 'O', 'S', 'C', 'S', 'A', 'C', 'L', 'N', 'A', 'A', 'E'},
				             {'R', 'N', 'T', 'T', 'E', 'W', 'E', 'A', 'L', 'A', 'S', 'N', 'C', 'N'},
				             {'S', 'S', 'O', 'S', 'A', 'E', 'A', 'S', 'N', 'O', 'S', 'S', 'N', 'D'},
				             {'O', 'F', 'N', 'E', 'E', 'A', 'P', 'L', 'E', 'O', 'A', 'N', 'A', 'E'},
				             {'F', 'N', 'V', 'V', 'O', 'R', 'R', 'E', 'O', 'N', 'V', 'N', 'S', 'L'},
				             {'O', 'S', 'A', 'O', 'E', 'A', 'G', 'C', 'H', 'A', 'N', 'A', 'E', 'L'},
				             {'E', 'A', 'A', 'L', 'R', 'D', 'U', 'S', 'A', 'A', 'L', 'N', 'R', 'E'},
				             {'O', 'N', 'L', 'G', 'R', 'T', 'T', 'A', 'D', 'N', 'P', 'A', 'N', 'C'},
				             {'I', 'K', 'L', 'L', 'E', 'E', 'E', 'K', 'O', 'E', 'N', 'S', 'S', 'S'}};
	
		String [] words = {"ELSA", "ANNA", "KRISTOFF", "SVEN", "HANS", "OLAF", "ARENDELLE",
				"SONGS", "ICE", "SNOWMAN", "CASTLE", "POWERS", "GLOVES", "SAUNA"};
		
		String [] row = new String[14];
		String [] brow = new String[14];
		String [] col = new String[14];
		String [] upcol = new String[14];
		String [] tLDiag = new String[14];
		String [] bTLDiag = new String[14];
		String [] tRDiag = new String[14];
		String [] bTRDiag = new String[14];
		String [] tRDiagLower = new String[14];
		String [] bTRDiagLower = new String[14];
		String [] tLDiagLower= new String[14];
		String [] bTLDiagLower = new String[14];
		
		row = rowToString(puzzle);
		brow = browToString(puzzle);
		col = colToString(puzzle);
		upcol = bcolToString(puzzle);
		rowFowardPosition(row, words);
		rowBackwardPosition(brow, words);
		columnDownPosition(col, words);
		columnUpPosition(upcol, words);
		tLDiag = topLeftDiag(puzzle);
		topLeftDiagPosition(tLDiag, words);
		bTLDiag = backTopLeftDiag(puzzle);
		topLeftDiagPositionBackward(bTLDiag, words);
		tRDiag = topRightDiag(puzzle);
		topRightDiagPosition(tRDiag, words);
		bTRDiag = backTopRightDiag(puzzle);
		topRightDiagPositionBackwards(bTRDiag, words);
		tRDiagLower = topRightDiagLower(puzzle);	
		lowerTopRightDiagPositionBackwards(tRDiagLower, words);
		bTRDiagLower = backTopRightDiagLower(puzzle);
		tLDiagLower = topLeftDiagLower(puzzle);
		bTLDiagLower = backTopLeftDiagLower(puzzle);
		
	}
	
	public static String[] rowToString(char[][] p) {
		
		StringBuilder rowString = new StringBuilder();
		String [] row = new String[14];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				row[i] = rowString.append(p[i][j]).toString();
			}
			rowString.delete(0, rowString.length() + 1);
		}
		return row;
	}
	
	public static String[] browToString(char[][] p) {
		
		StringBuilder rowString = new StringBuilder();
		String [] brow = new String[14];
		for (int i = 0; i < p.length; i++) {
			for (int j = p[0].length-1; j >= 0; j--) {
				brow[i] = rowString.append(p[i][j]).toString();
			}
			rowString.delete(0, rowString.length() + 1);
		}
		
		return brow;
	}
	
	public static String[] colToString(char[][] p) {
		
		StringBuilder colString = new StringBuilder();
		String [] col = new String[14];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				col[i] = colString.append(p[j][i]).toString();
			}
			colString.delete(0, colString.length() + 1);
		}
		return col;
	}
	
	public static String[] bcolToString(char[][] p) {
		
		StringBuilder bcolString = new StringBuilder();
		String [] bcol = new String[14];
		for (int i = 0; i < p.length; i++) {
			for (int j = p[0].length-1; j >= 0; j--) {
				bcol[i] = bcolString.append(p[j][i]).toString();
			}
			bcolString.delete(0, bcolString.length() + 1);
		}
		
		return bcol;
	}
	
	public static String[] topLeftDiag(char[][] p) {
		
		StringBuilder topLeftString = new StringBuilder();
		String [] tLString = new String[14];
		int row;
		int col;
		int i = 0;
		
		for (col = 0; col < p[0].length; col++) {
			int j = col;
			for (row = 0; j < p[0].length; row++) {
				tLString[i] = topLeftString.append(p[row][j]).toString();
				j++;
			}
			i++;
			topLeftString.delete(0, topLeftString.length()+1);
		}
		
		return tLString;
	}
	
	public static String[] backTopLeftDiag(char[][] p) {
		
		StringBuilder bTopLeftString = new StringBuilder();
		String [] bTLString = new String[14];
		int row;
		int col;
		int i = 0;
		
		for (row = p.length-1; row >= 0; row--) {
			int j = row;
			for (col = p[0].length-1; j >= 0; col--) {
				bTLString[i] = bTopLeftString.append(p[j][col]).toString();
				j--;
			}
			i++;
			bTopLeftString.delete(0, bTopLeftString.length()+1);
		}
		
		return bTLString;
	}
		
		public static String[] topRightDiag(char[][] p) {
			
			StringBuilder topRightString = new StringBuilder();
			String [] tRString = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (col = p[0].length-1; col >= 0; col--) {
				int j = col;
				for (row = 0; j >= 0; row++) {
					tRString[i] = topRightString.append(p[row][j]).toString();
					j--;
				}
				i++;
				topRightString.delete(0, topRightString.length()+1);
			}
			
			return tRString;
	}
		
		public static String[] backTopRightDiag(char[][] p) {
			
			StringBuilder bTopRightString = new StringBuilder();
			String [] bTRString = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (row = p.length-1; row >= 0; row--) {
				int j = row;
				for (col = 0; j >= 0; col++) {
					bTRString[i] = bTopRightString.append(p[j][col]).toString();
					j--;
				}
				i++;
				bTopRightString.delete(0, bTopRightString.length()+1);
			}
			
			return bTRString;
	}
		
		public static String[] topRightDiagLower(char[][] p) {
			
			StringBuilder topRightString = new StringBuilder();
			String [] tRString = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (row = 0; row < p.length; row++) {
				int j = row;
				for (col = p[0].length-1; j < p[0].length ; col--) {
					tRString[i] = topRightString.append(p[j][col]).toString();
					j++;
				}
				i++;
				topRightString.delete(0, topRightString.length()+1);
			}
			
			return tRString;
	}
		
		public static String[] backTopRightDiagLower(char[][] p) {
			
			StringBuilder bTopRightString = new StringBuilder();
			String [] bTRString = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (col = 0; col < p[0].length; col++) {
				int j = col;
				for (row = p.length-1; j < p[0].length ; row--) {
					bTRString[i] = bTopRightString.append(p[row][j]).toString();
					j++;
				}
				i++;
				bTopRightString.delete(0, bTopRightString.length()+1);
			}
			
			return bTRString;
	}
		
		public static String[] topLeftDiagLower(char[][] p) {
			
			StringBuilder topLeftStringLower = new StringBuilder();
			String [] tLStringLower = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (row = 0; row < p.length; row++) {
				int j = row;
				for (col = 0; j < p[0].length; col++) {
					tLStringLower[i] = topLeftStringLower.append(p[j][col]).toString();
					j++;
				}
				i++;
				topLeftStringLower.delete(0, topLeftStringLower.length()+1);
			}
			
			return tLStringLower;
		}
		
	public static String[] backTopLeftDiagLower(char[][] p) {
			
			StringBuilder backTopLeftStringLower = new StringBuilder();
			String [] bTLStringLower = new String[14];
			int row;
			int col;
			int i = 0;
			
			for (col = p.length-1; col >= 0; col--) {
				int j = col;
				for (row = p.length-1; j >= 0; row--) {
					bTLStringLower[i] = backTopLeftStringLower.append(p[row][j]).toString();
					j--;
				}
				i++;
				backTopLeftStringLower.delete(0, backTopLeftStringLower.length()+1);
			}
			
			return bTLStringLower;
		}
	
	public static void rowFowardPosition(String[] row, String[] w) {
		int position;
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < w.length; j++) {
				position = row[i].indexOf(w[j]);
				if (position != -1)
					System.out.println("The word "+w[j]+" begins at row "+(i+1)
							+ " position "+(position+1));
			}
		}
	}
	
	public static void rowBackwardPosition(String[] brow, String[] w) {
		int position;
		for (int i = 0; i < brow.length; i++) {
			for (int j = 0; j < w.length; j++) {
				position = brow[i].indexOf(w[j]);
				if (position != -1)
					System.out.println("The word "+w[j]+" begins going backwards at row "+(i+1)
							+ " position "+(brow.length - position));
			}
		}
	}
	
	public static void columnDownPosition(String[] col, String[] w) {
		int row;
		for (int i = 0; i < col.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = col[i].indexOf(w[j]);
				if (row != -1)
					System.out.println("The word "+w[j]+" begins going downwards at row "+(row+1)
							+ " position "+(i+1));
			}
		}
	}
	
	public static void columnUpPosition(String[] ucol, String[] w) {
		int row;
		for (int i = 0; i < ucol.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = ucol[i].indexOf(w[j]);
				if (row != -1)
					System.out.println("The word "+w[j]+" begins going upwards at row "+
				(ucol.length - row)+ " position "+(i+1));
			}
		}
	}
	
	public static void topLeftDiagPosition(String[] tLDiag, String[] w) {
		int row;
		for (int i = 0; i < tLDiag.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = tLDiag[i].indexOf(w[j]);
				if (row != -1)
					System.out.println("The word "+w[j]+" begins going down to the right at row "+
							(13 - w[j].length() - tLDiag[i].indexOf(w[j]))+ 
							" position "+(14 - tLDiag[i].length()+i));
							// old bellow
							//(tLDiag.length - row)+ " position "+(i+1));
			}			
		}
	}
	
	public static void topLeftDiagPositionBackward(String[] bTLDiag, String[] w) {
		int row;
		for (int i = 0; i < bTLDiag.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = bTLDiag[i].indexOf(w[j]);
				if (row != -1)
					System.out.println("The word "+w[j]+" begins going up to the left at row "+
				(row + w[j].length())+ " position "+((14 -  bTLDiag[i].indexOf(w[j]))));
			}
		}
	}
	
	public static void topRightDiagPosition(String[] tRDiag, String[] w) {
		int row;
		for (int i = 0; i < tRDiag.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = tRDiag[i].indexOf(w[j]);
				if (row != -1)
					System.out.println("The word "+w[j]+" begins going down to the left at row "+
						(13-w[j].length() - tRDiag[i].indexOf(w[j]))+
						" position "+(14 - tRDiag[i].length()+i));
			}
		}
	}
	
	public static void topRightDiagPositionBackwards(String[] bTRDiag, String[] w) {
		int row;
		for (int i = 0; i < bTRDiag.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = bTRDiag[i].indexOf(w[j]);
				if ( row != -1)
					System.out.println("The word "+w[j]+" begins going up to the right at row "+
							(13-w[j].length() - bTRDiag[i].indexOf(w[j]))+
							" position "+(14 - bTRDiag[i].length()+i));
			}
		}
	}
	public static void lowerTopRightDiagPositionBackwards(String[] lowerTRDiag, String[] w) {
		int row;
		for (int i = 0; i < lowerTRDiag.length; i++) {
			for (int j = 0; j < w.length; j++) {
				row = lowerTRDiag[i].indexOf(w[j]);
			   	if ( row != -1)
					System.out.println("The word "+w[j]+" begins going up to the right at row "+
							(14 - lowerTRDiag[i].length() + w[j].length()+1)+
							" position "+(13-w[j].length() + lowerTRDiag[i].indexOf(w[j])));
			}
		}
	}
}