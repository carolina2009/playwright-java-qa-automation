\# Test Scenarios



This document contains the main test scenarios automated in this project.



\## Login Test Scenarios



| Test Case ID | Scenario | Test Data | Expected Result |

|---|---|---|---|

| TC001 | Valid login | Username: tomsmith / Password: SuperSecretPassword! | User should access the secure area |

| TC002 | Invalid username | Username: wrongUser / Password: wrongPassword | Error message should be displayed |

| TC003 | Invalid password | Username: tomsmith / Password: wrongPassword | Password error message should be displayed |

| TC004 | Invalid credentials using data-driven testing | Multiple invalid users and passwords | Expected error message should be displayed |



\## UI Interaction Test Scenarios



| Test Case ID | Scenario | Expected Result |

|---|---|---|

| TC005 | Check and uncheck checkbox | Checkbox state should change correctly |

| TC006 | Select dropdown option | Selected value should match the expected option |

| TC007 | Validate page heading visibility | Page heading should be visible |

| TC008 | Accept JavaScript alert | Alert should be accepted and result message should be displayed |



\## Playwright Basic Practice Scenarios



| Test Case ID | Scenario | Expected Result |

|---|---|---|

| TC009 | Open page and validate title | Page title should contain expected text |

| TC010 | Read text from page | Heading text should match expected content |

| TC011 | Fill login form fields | Input values should match entered data |

