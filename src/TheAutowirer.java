import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import annotations.Autowired;
import annotations.Component;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class TheAutowirer 
{
	public static void main(String[] args) throws Exception
	{
		// set to scan default package
		ScanResult results = new FastClasspathScanner("").scan();	
		
		// SCAN ALL @Component
		// gives all the fully qualified names
		List<String> allResults = results.getNamesOfClassesWithAnnotation(Component.class);
		System.out.println(allResults);
		
		// STORE an instance of each component
		LinkedHashMap<Class, Object> componentMap = new LinkedHashMap<>();
		
		for (String s : allResults)
		{
			// get class object
			Class c = Class.forName(s);

			// MAP each instance to the class
			componentMap.put(c, c.newInstance());
		}
		
		System.out.println(componentMap);
		
		
		// search each component for @Autowired, assign associated object
		for (Object o : componentMap.values())
		{
			Field[] fields = o.getClass().getDeclaredFields();
			
			for (Field f : fields)
			{
				// check if field has @Autowired
				if (f.isAnnotationPresent(Autowired.class))
				{
					// assign component if any (null if nothing)
					f.setAccessible(true);
					f.set(o, componentMap.get(f.getType()));
				}
			}
		}

		// print components to see if they now have contents
		System.out.println(componentMap);
	}
}
