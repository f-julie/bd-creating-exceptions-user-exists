In IntelliJ, go to "IntelliJ IDEA" → "Preferences..." → "Editor" → "Inspections" → "Java" → "Serialization issues" →
"Serializable class without 'serialVersionUID'" - select the check box and click 'OK'. This will make IntelliJ tell
you when a `Serializable` class is missing the `serialVersionUID` field.

To have IntelliJ generate the `serialVersionUID` for you, return to your exception class. The class name should be
underlined. If you hover over it, you should see the option to "Add 'serialVersionUID' field". Select that text or
press ⌥⇧↵ to generate the `serialVersionUID`.
