package designpatterns.utils;


public class ConfigReaderFactory<T> {
	
		public ConfigReader<T> createReader(FileType fileType) {
			
			if(fileType == FileType.JSON)
				return new JSONConfigReader<T>();
			
			else if(fileType == FileType.XML)
				return new XMLConfigReader<T>();
			
			return null;
		}
}
