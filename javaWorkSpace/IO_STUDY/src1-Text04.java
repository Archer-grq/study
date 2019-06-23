public static byte[] fileToByteArray(String path) {
		File file=new File(path);
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		int len=-1;
		try {
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			
			byte[] temp=new byte[1024];
			while((len=is.read(temp))!=-1) {
				baos.write(temp,0,len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IO