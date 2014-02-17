package com.sample.test;

import java.lang.reflect.Field;
import org.springframework.util.ClassUtils;
import android.test.InstrumentationTestCase;

public class RTest extends InstrumentationTestCase {

	public void testAllAttributesFacebookVsApp() throws Exception {
		compareR(com.facebook.android.R.class, com.sample.app.R.class);
	}

	public void testAllAttributesFacebookVsCommon() throws Exception {
		compareR(com.facebook.android.R.class, com.sample.common.R.class);
	}

	public void testAllAttributesAppVsCommon() throws Exception {
		compareR(com.sample.common.R.class, com.sample.app.R.class);
	}

	private static void compareR(Class<?> r1, Class<?> extendedR1)
			throws Exception {
		for (Class<?> section : r1.getClasses()) {
			Class<?> extendedSection = getClassBySimpleName(extendedR1, section.getSimpleName());
			if (extendedSection == null) {
				System.err.println("Skipping section " + section.getName()
						+ " as it was not found in " + extendedR1);
			} else {
				for (Field f : section.getDeclaredFields()) {
					if (ClassUtils.isPrimitiveOrWrapper(f.getType())) {
						Object origValue = f.get(null);
						Object newValue = extendedSection.getField(f.getName()).get(null);
						assertEquals("Failed testing " + f.getName(), origValue, newValue);
					} else {
						System.err.println("Skipping " + f.getName());
					}
				}
			}
		}
	}

	private static Class<?> getClassBySimpleName(Class<?> clazz,
			String simpleName) {
		for (Class<?> cls : clazz.getClasses()) {
			if (cls.getSimpleName().equals(simpleName)) {
				return cls;
			}
		}
		return null;
	}
}