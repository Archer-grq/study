Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static void byteArrayToFile(byte[] b,String path) {
		File file=new File(path);
		OutputStream os=null;
		InputStream btis=null;
		
		try {
			os=new FileOutputStream(file);
			btis=new ByteArrayInputStream(b);
			