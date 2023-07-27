package com.protecgames.flashlight;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double sounduz = 0;
	private HashMap<String, Object> listmap = new HashMap<>();
	private boolean flashLightStatus = false;
	private boolean hasCameraFlash = false;
	private boolean bac = false;
	private double num = 0;
	private double numlock = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear7;
	private LinearLayout linear3;
	private LinearLayout linear15;
	private LinearLayout linear14;
	private LinearLayout linear13;
	private ImageView imageview2;
	private ImageView imageview4;
	private ImageView imageview3;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private ImageView imageview1;
	private LinearLayout linear11;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private ImageView imageview5;
	private TextView textview1;
	private TextView textview2;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	
	private MediaPlayer m;
	private SoundPool sound;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear7 = findViewById(R.id.linear7);
		linear3 = findViewById(R.id.linear3);
		linear15 = findViewById(R.id.linear15);
		linear14 = findViewById(R.id.linear14);
		linear13 = findViewById(R.id.linear13);
		imageview2 = findViewById(R.id.imageview2);
		imageview4 = findViewById(R.id.imageview4);
		imageview3 = findViewById(R.id.imageview3);
		linear4 = findViewById(R.id.linear4);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		linear11 = findViewById(R.id.linear11);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		imageview5 = findViewById(R.id.imageview5);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		button5 = findViewById(R.id.button5);
		button6 = findViewById(R.id.button6);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				if (num == 1) {
					num = 0;
					imageview2.setImageResource(R.drawable.day_night_2);
					linear1.setBackgroundResource(R.drawable.backround);
				}
				else {
					num = 1;
					imageview2.setImageResource(R.drawable.day_night_1);
					linear1.setBackgroundResource(R.drawable.salom);
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				if (num == 1) {
					num = 0;
					imageview3.setImageResource(R.drawable.ic_up_down_1);
					linear9.setVisibility(View.GONE);
					linear10.setVisibility(View.GONE);
				}
				else {
					num = 1;
					imageview3.setImageResource(R.drawable.ic_up_down_2);
					linear9.setVisibility(View.VISIBLE);
					linear10.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				if (flashLightStatus) {
					_setFlashEnabled(false);
					imageview1.setImageResource(R.drawable.icon_off);
					imageview4.setImageResource(R.drawable.icon_2);
				}
				else {
					_setFlashEnabled(true);
					imageview1.setImageResource(R.drawable.icon_on);
					imageview4.setImageResource(R.drawable.icon_1);
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(true);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(false);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(true);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(false);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(true);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(false);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(true);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(false);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(true);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(false);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(true);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				_setFlashEnabled(false);
																																																				t = new TimerTask() {
																																																					@Override
																																																					public void run() {
																																																						runOnUiThread(new Runnable() {
																																																							@Override
																																																							public void run() {
																																																								_setFlashEnabled(true);
																																																								t = new TimerTask() {
																																																									@Override
																																																									public void run() {
																																																										runOnUiThread(new Runnable() {
																																																											@Override
																																																											public void run() {
																																																												_setFlashEnabled(false);
																																																												t = new TimerTask() {
																																																													@Override
																																																													public void run() {
																																																														runOnUiThread(new Runnable() {
																																																															@Override
																																																															public void run() {
																																																																_setFlashEnabled(true);
																																																																t = new TimerTask() {
																																																																	@Override
																																																																	public void run() {
																																																																		runOnUiThread(new Runnable() {
																																																																			@Override
																																																																			public void run() {
																																																																				_setFlashEnabled(false);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(true);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												imageview4.setImageResource(R.drawable.icon_2);
																																																																												_setFlashEnabled(false);
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(100));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(100));
																																																																			}
																																																																		});
																																																																	}
																																																																};
																																																																_timer.schedule(t, (int)(100));
																																																															}
																																																														});
																																																													}
																																																												};
																																																												_timer.schedule(t, (int)(100));
																																																											}
																																																										});
																																																									}
																																																								};
																																																								_timer.schedule(t, (int)(100));
																																																							}
																																																						});
																																																					}
																																																				};
																																																				_timer.schedule(t, (int)(350));
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(350));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(350));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(350));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(350));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(350));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(350));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(100));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(100));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(100));
															}
														});
													}
												};
												_timer.schedule(t, (int)(100));
											}
										});
									}
								};
								_timer.schedule(t, (int)(100));
							}
						});
					}
				};
				_timer.schedule(t, (int)(500));
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(true);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(false);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(true);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(false);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(true);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(false);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(true);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(false);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(true);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(false);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(true);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				imageview4.setImageResource(R.drawable.icon_2);
																																																				_setFlashEnabled(false);
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(100));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(100));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(100));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(1000));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(100));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(100));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(100));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(1000));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(100));
															}
														});
													}
												};
												_timer.schedule(t, (int)(100));
											}
										});
									}
								};
								_timer.schedule(t, (int)(100));
							}
						});
					}
				};
				_timer.schedule(t, (int)(500));
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				_setFlashEnabled(true);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(false);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(true);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(false);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(true);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(false);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(true);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(false);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(true);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(false);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(true);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(false);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				_setFlashEnabled(true);
																																																				t = new TimerTask() {
																																																					@Override
																																																					public void run() {
																																																						runOnUiThread(new Runnable() {
																																																							@Override
																																																							public void run() {
																																																								_setFlashEnabled(false);
																																																								t = new TimerTask() {
																																																									@Override
																																																									public void run() {
																																																										runOnUiThread(new Runnable() {
																																																											@Override
																																																											public void run() {
																																																												_setFlashEnabled(true);
																																																												t = new TimerTask() {
																																																													@Override
																																																													public void run() {
																																																														runOnUiThread(new Runnable() {
																																																															@Override
																																																															public void run() {
																																																																_setFlashEnabled(false);
																																																																t = new TimerTask() {
																																																																	@Override
																																																																	public void run() {
																																																																		runOnUiThread(new Runnable() {
																																																																			@Override
																																																																			public void run() {
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																imageview4.setImageResource(R.drawable.icon_2);
																																																																																_setFlashEnabled(false);
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(300));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(300));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(300));
																																																																			}
																																																																		});
																																																																	}
																																																																};
																																																																_timer.schedule(t, (int)(300));
																																																															}
																																																														});
																																																													}
																																																												};
																																																												_timer.schedule(t, (int)(300));
																																																											}
																																																										});
																																																									}
																																																								};
																																																								_timer.schedule(t, (int)(300));
																																																							}
																																																						});
																																																					}
																																																				};
																																																				_timer.schedule(t, (int)(300));
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(300));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(300));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(300));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(300));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(300));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(300));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(300));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(300));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(300));
															}
														});
													}
												};
												_timer.schedule(t, (int)(300));
											}
										});
									}
								};
								_timer.schedule(t, (int)(300));
							}
						});
					}
				};
				_timer.schedule(t, (int)(300));
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				_setFlashEnabled(true);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(false);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(true);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(false);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(true);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(false);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(true);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(false);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(true);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(false);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(true);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(false);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				_setFlashEnabled(true);
																																																				t = new TimerTask() {
																																																					@Override
																																																					public void run() {
																																																						runOnUiThread(new Runnable() {
																																																							@Override
																																																							public void run() {
																																																								_setFlashEnabled(false);
																																																								t = new TimerTask() {
																																																									@Override
																																																									public void run() {
																																																										runOnUiThread(new Runnable() {
																																																											@Override
																																																											public void run() {
																																																												_setFlashEnabled(true);
																																																												t = new TimerTask() {
																																																													@Override
																																																													public void run() {
																																																														runOnUiThread(new Runnable() {
																																																															@Override
																																																															public void run() {
																																																																_setFlashEnabled(false);
																																																																t = new TimerTask() {
																																																																	@Override
																																																																	public void run() {
																																																																		runOnUiThread(new Runnable() {
																																																																			@Override
																																																																			public void run() {
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																imageview4.setImageResource(R.drawable.icon_2);
																																																																																_setFlashEnabled(false);
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(200));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(200));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(200));
																																																																			}
																																																																		});
																																																																	}
																																																																};
																																																																_timer.schedule(t, (int)(200));
																																																															}
																																																														});
																																																													}
																																																												};
																																																												_timer.schedule(t, (int)(200));
																																																											}
																																																										});
																																																									}
																																																								};
																																																								_timer.schedule(t, (int)(200));
																																																							}
																																																						});
																																																					}
																																																				};
																																																				_timer.schedule(t, (int)(200));
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(200));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(200));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(200));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(200));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(200));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(200));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(200));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(200));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(200));
															}
														});
													}
												};
												_timer.schedule(t, (int)(200));
											}
										});
									}
								};
								_timer.schedule(t, (int)(200));
							}
						});
					}
				};
				_timer.schedule(t, (int)(200));
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				_setFlashEnabled(true);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(false);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(true);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(false);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(true);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(false);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(true);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(false);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(true);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(false);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(true);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(false);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				_setFlashEnabled(true);
																																																				t = new TimerTask() {
																																																					@Override
																																																					public void run() {
																																																						runOnUiThread(new Runnable() {
																																																							@Override
																																																							public void run() {
																																																								_setFlashEnabled(false);
																																																								t = new TimerTask() {
																																																									@Override
																																																									public void run() {
																																																										runOnUiThread(new Runnable() {
																																																											@Override
																																																											public void run() {
																																																												_setFlashEnabled(true);
																																																												t = new TimerTask() {
																																																													@Override
																																																													public void run() {
																																																														runOnUiThread(new Runnable() {
																																																															@Override
																																																															public void run() {
																																																																_setFlashEnabled(false);
																																																																t = new TimerTask() {
																																																																	@Override
																																																																	public void run() {
																																																																		runOnUiThread(new Runnable() {
																																																																			@Override
																																																																			public void run() {
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																_setFlashEnabled(false);
																																																																																t = new TimerTask() {
																																																																																	@Override
																																																																																	public void run() {
																																																																																		runOnUiThread(new Runnable() {
																																																																																			@Override
																																																																																			public void run() {
																																																																																				_setFlashEnabled(true);
																																																																																				t = new TimerTask() {
																																																																																					@Override
																																																																																					public void run() {
																																																																																						runOnUiThread(new Runnable() {
																																																																																							@Override
																																																																																							public void run() {
																																																																																								_setFlashEnabled(false);
																																																																																								t = new TimerTask() {
																																																																																									@Override
																																																																																									public void run() {
																																																																																										runOnUiThread(new Runnable() {
																																																																																											@Override
																																																																																											public void run() {
																																																																																												_setFlashEnabled(true);
																																																																																												t = new TimerTask() {
																																																																																													@Override
																																																																																													public void run() {
																																																																																														runOnUiThread(new Runnable() {
																																																																																															@Override
																																																																																															public void run() {
																																																																																																_setFlashEnabled(false);
																																																																																																t = new TimerTask() {
																																																																																																	@Override
																																																																																																	public void run() {
																																																																																																		runOnUiThread(new Runnable() {
																																																																																																			@Override
																																																																																																			public void run() {
																																																																																																				_setFlashEnabled(true);
																																																																																																				t = new TimerTask() {
																																																																																																					@Override
																																																																																																					public void run() {
																																																																																																						runOnUiThread(new Runnable() {
																																																																																																							@Override
																																																																																																							public void run() {
																																																																																																								_setFlashEnabled(false);
																																																																																																								t = new TimerTask() {
																																																																																																									@Override
																																																																																																									public void run() {
																																																																																																										runOnUiThread(new Runnable() {
																																																																																																											@Override
																																																																																																											public void run() {
																																																																																																												_setFlashEnabled(true);
																																																																																																												t = new TimerTask() {
																																																																																																													@Override
																																																																																																													public void run() {
																																																																																																														runOnUiThread(new Runnable() {
																																																																																																															@Override
																																																																																																															public void run() {
																																																																																																																_setFlashEnabled(false);
																																																																																																																t = new TimerTask() {
																																																																																																																	@Override
																																																																																																																	public void run() {
																																																																																																																		runOnUiThread(new Runnable() {
																																																																																																																			@Override
																																																																																																																			public void run() {
																																																																																																																				_setFlashEnabled(true);
																																																																																																																				t = new TimerTask() {
																																																																																																																					@Override
																																																																																																																					public void run() {
																																																																																																																						runOnUiThread(new Runnable() {
																																																																																																																							@Override
																																																																																																																							public void run() {
																																																																																																																								_setFlashEnabled(false);
																																																																																																																								t = new TimerTask() {
																																																																																																																									@Override
																																																																																																																									public void run() {
																																																																																																																										runOnUiThread(new Runnable() {
																																																																																																																											@Override
																																																																																																																											public void run() {
																																																																																																																												_setFlashEnabled(true);
																																																																																																																												t = new TimerTask() {
																																																																																																																													@Override
																																																																																																																													public void run() {
																																																																																																																														runOnUiThread(new Runnable() {
																																																																																																																															@Override
																																																																																																																															public void run() {
																																																																																																																																_setFlashEnabled(false);
																																																																																																																																t = new TimerTask() {
																																																																																																																																	@Override
																																																																																																																																	public void run() {
																																																																																																																																		runOnUiThread(new Runnable() {
																																																																																																																																			@Override
																																																																																																																																			public void run() {
																																																																																																																																				_setFlashEnabled(true);
																																																																																																																																				t = new TimerTask() {
																																																																																																																																					@Override
																																																																																																																																					public void run() {
																																																																																																																																						runOnUiThread(new Runnable() {
																																																																																																																																							@Override
																																																																																																																																							public void run() {
																																																																																																																																								_setFlashEnabled(false);
																																																																																																																																								t = new TimerTask() {
																																																																																																																																									@Override
																																																																																																																																									public void run() {
																																																																																																																																										runOnUiThread(new Runnable() {
																																																																																																																																											@Override
																																																																																																																																											public void run() {
																																																																																																																																												_setFlashEnabled(true);
																																																																																																																																												t = new TimerTask() {
																																																																																																																																													@Override
																																																																																																																																													public void run() {
																																																																																																																																														runOnUiThread(new Runnable() {
																																																																																																																																															@Override
																																																																																																																																															public void run() {
																																																																																																																																																imageview4.setImageResource(R.drawable.icon_2);
																																																																																																																																																_setFlashEnabled(false);
																																																																																																																																															}
																																																																																																																																														});
																																																																																																																																													}
																																																																																																																																												};
																																																																																																																																												_timer.schedule(t, (int)(100));
																																																																																																																																											}
																																																																																																																																										});
																																																																																																																																									}
																																																																																																																																								};
																																																																																																																																								_timer.schedule(t, (int)(100));
																																																																																																																																							}
																																																																																																																																						});
																																																																																																																																					}
																																																																																																																																				};
																																																																																																																																				_timer.schedule(t, (int)(100));
																																																																																																																																			}
																																																																																																																																		});
																																																																																																																																	}
																																																																																																																																};
																																																																																																																																_timer.schedule(t, (int)(100));
																																																																																																																															}
																																																																																																																														});
																																																																																																																													}
																																																																																																																												};
																																																																																																																												_timer.schedule(t, (int)(100));
																																																																																																																											}
																																																																																																																										});
																																																																																																																									}
																																																																																																																								};
																																																																																																																								_timer.schedule(t, (int)(100));
																																																																																																																							}
																																																																																																																						});
																																																																																																																					}
																																																																																																																				};
																																																																																																																				_timer.schedule(t, (int)(100));
																																																																																																																			}
																																																																																																																		});
																																																																																																																	}
																																																																																																																};
																																																																																																																_timer.schedule(t, (int)(100));
																																																																																																															}
																																																																																																														});
																																																																																																													}
																																																																																																												};
																																																																																																												_timer.schedule(t, (int)(100));
																																																																																																											}
																																																																																																										});
																																																																																																									}
																																																																																																								};
																																																																																																								_timer.schedule(t, (int)(100));
																																																																																																							}
																																																																																																						});
																																																																																																					}
																																																																																																				};
																																																																																																				_timer.schedule(t, (int)(100));
																																																																																																			}
																																																																																																		});
																																																																																																	}
																																																																																																};
																																																																																																_timer.schedule(t, (int)(100));
																																																																																															}
																																																																																														});
																																																																																													}
																																																																																												};
																																																																																												_timer.schedule(t, (int)(100));
																																																																																											}
																																																																																										});
																																																																																									}
																																																																																								};
																																																																																								_timer.schedule(t, (int)(100));
																																																																																							}
																																																																																						});
																																																																																					}
																																																																																				};
																																																																																				_timer.schedule(t, (int)(100));
																																																																																			}
																																																																																		});
																																																																																	}
																																																																																};
																																																																																_timer.schedule(t, (int)(100));
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(100));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(100));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(100));
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																_setFlashEnabled(false);
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(50));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(50));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(50));
																																																																			}
																																																																		});
																																																																	}
																																																																};
																																																																_timer.schedule(t, (int)(100));
																																																															}
																																																														});
																																																													}
																																																												};
																																																												_timer.schedule(t, (int)(100));
																																																											}
																																																										});
																																																									}
																																																								};
																																																								_timer.schedule(t, (int)(100));
																																																							}
																																																						});
																																																					}
																																																				};
																																																				_timer.schedule(t, (int)(100));
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(100));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(100));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(100));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(100));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(100));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(100));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(100));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(100));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(100));
															}
														});
													}
												};
												_timer.schedule(t, (int)(100));
											}
										});
									}
								};
								_timer.schedule(t, (int)(100));
							}
						});
					}
				};
				_timer.schedule(t, (int)(100));
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sounduz = sound.play((int)(1), 1.0f, 1.0f, 1, (int)(0), 1.0f);
				imageview4.setImageResource(R.drawable.icon_1);
				_setFlashEnabled(true);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_setFlashEnabled(false);
								t = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												_setFlashEnabled(true);
												t = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_setFlashEnabled(false);
																t = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				_setFlashEnabled(true);
																				t = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								_setFlashEnabled(false);
																								t = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												_setFlashEnabled(true);
																												t = new TimerTask() {
																													@Override
																													public void run() {
																														runOnUiThread(new Runnable() {
																															@Override
																															public void run() {
																																_setFlashEnabled(false);
																																t = new TimerTask() {
																																	@Override
																																	public void run() {
																																		runOnUiThread(new Runnable() {
																																			@Override
																																			public void run() {
																																				_setFlashEnabled(true);
																																				t = new TimerTask() {
																																					@Override
																																					public void run() {
																																						runOnUiThread(new Runnable() {
																																							@Override
																																							public void run() {
																																								_setFlashEnabled(false);
																																								t = new TimerTask() {
																																									@Override
																																									public void run() {
																																										runOnUiThread(new Runnable() {
																																											@Override
																																											public void run() {
																																												_setFlashEnabled(true);
																																												t = new TimerTask() {
																																													@Override
																																													public void run() {
																																														runOnUiThread(new Runnable() {
																																															@Override
																																															public void run() {
																																																_setFlashEnabled(false);
																																																t = new TimerTask() {
																																																	@Override
																																																	public void run() {
																																																		runOnUiThread(new Runnable() {
																																																			@Override
																																																			public void run() {
																																																				_setFlashEnabled(true);
																																																				t = new TimerTask() {
																																																					@Override
																																																					public void run() {
																																																						runOnUiThread(new Runnable() {
																																																							@Override
																																																							public void run() {
																																																								_setFlashEnabled(false);
																																																								t = new TimerTask() {
																																																									@Override
																																																									public void run() {
																																																										runOnUiThread(new Runnable() {
																																																											@Override
																																																											public void run() {
																																																												_setFlashEnabled(true);
																																																												t = new TimerTask() {
																																																													@Override
																																																													public void run() {
																																																														runOnUiThread(new Runnable() {
																																																															@Override
																																																															public void run() {
																																																																_setFlashEnabled(false);
																																																																t = new TimerTask() {
																																																																	@Override
																																																																	public void run() {
																																																																		runOnUiThread(new Runnable() {
																																																																			@Override
																																																																			public void run() {
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																_setFlashEnabled(false);
																																																																																t = new TimerTask() {
																																																																																	@Override
																																																																																	public void run() {
																																																																																		runOnUiThread(new Runnable() {
																																																																																			@Override
																																																																																			public void run() {
																																																																																				_setFlashEnabled(true);
																																																																																				t = new TimerTask() {
																																																																																					@Override
																																																																																					public void run() {
																																																																																						runOnUiThread(new Runnable() {
																																																																																							@Override
																																																																																							public void run() {
																																																																																								_setFlashEnabled(false);
																																																																																								t = new TimerTask() {
																																																																																									@Override
																																																																																									public void run() {
																																																																																										runOnUiThread(new Runnable() {
																																																																																											@Override
																																																																																											public void run() {
																																																																																												_setFlashEnabled(true);
																																																																																												t = new TimerTask() {
																																																																																													@Override
																																																																																													public void run() {
																																																																																														runOnUiThread(new Runnable() {
																																																																																															@Override
																																																																																															public void run() {
																																																																																																_setFlashEnabled(false);
																																																																																																t = new TimerTask() {
																																																																																																	@Override
																																																																																																	public void run() {
																																																																																																		runOnUiThread(new Runnable() {
																																																																																																			@Override
																																																																																																			public void run() {
																																																																																																				_setFlashEnabled(true);
																																																																																																				t = new TimerTask() {
																																																																																																					@Override
																																																																																																					public void run() {
																																																																																																						runOnUiThread(new Runnable() {
																																																																																																							@Override
																																																																																																							public void run() {
																																																																																																								_setFlashEnabled(false);
																																																																																																								t = new TimerTask() {
																																																																																																									@Override
																																																																																																									public void run() {
																																																																																																										runOnUiThread(new Runnable() {
																																																																																																											@Override
																																																																																																											public void run() {
																																																																																																												_setFlashEnabled(true);
																																																																																																												t = new TimerTask() {
																																																																																																													@Override
																																																																																																													public void run() {
																																																																																																														runOnUiThread(new Runnable() {
																																																																																																															@Override
																																																																																																															public void run() {
																																																																																																																_setFlashEnabled(false);
																																																																																																																t = new TimerTask() {
																																																																																																																	@Override
																																																																																																																	public void run() {
																																																																																																																		runOnUiThread(new Runnable() {
																																																																																																																			@Override
																																																																																																																			public void run() {
																																																																																																																				_setFlashEnabled(true);
																																																																																																																				t = new TimerTask() {
																																																																																																																					@Override
																																																																																																																					public void run() {
																																																																																																																						runOnUiThread(new Runnable() {
																																																																																																																							@Override
																																																																																																																							public void run() {
																																																																																																																								_setFlashEnabled(false);
																																																																																																																								t = new TimerTask() {
																																																																																																																									@Override
																																																																																																																									public void run() {
																																																																																																																										runOnUiThread(new Runnable() {
																																																																																																																											@Override
																																																																																																																											public void run() {
																																																																																																																												_setFlashEnabled(true);
																																																																																																																												t = new TimerTask() {
																																																																																																																													@Override
																																																																																																																													public void run() {
																																																																																																																														runOnUiThread(new Runnable() {
																																																																																																																															@Override
																																																																																																																															public void run() {
																																																																																																																																_setFlashEnabled(false);
																																																																																																																																t = new TimerTask() {
																																																																																																																																	@Override
																																																																																																																																	public void run() {
																																																																																																																																		runOnUiThread(new Runnable() {
																																																																																																																																			@Override
																																																																																																																																			public void run() {
																																																																																																																																				_setFlashEnabled(true);
																																																																																																																																				t = new TimerTask() {
																																																																																																																																					@Override
																																																																																																																																					public void run() {
																																																																																																																																						runOnUiThread(new Runnable() {
																																																																																																																																							@Override
																																																																																																																																							public void run() {
																																																																																																																																								_setFlashEnabled(false);
																																																																																																																																								t = new TimerTask() {
																																																																																																																																									@Override
																																																																																																																																									public void run() {
																																																																																																																																										runOnUiThread(new Runnable() {
																																																																																																																																											@Override
																																																																																																																																											public void run() {
																																																																																																																																												_setFlashEnabled(true);
																																																																																																																																												t = new TimerTask() {
																																																																																																																																													@Override
																																																																																																																																													public void run() {
																																																																																																																																														runOnUiThread(new Runnable() {
																																																																																																																																															@Override
																																																																																																																																															public void run() {
																																																																																																																																																imageview4.setImageResource(R.drawable.icon_2);
																																																																																																																																																_setFlashEnabled(false);
																																																																																																																																															}
																																																																																																																																														});
																																																																																																																																													}
																																																																																																																																												};
																																																																																																																																												_timer.schedule(t, (int)(200));
																																																																																																																																											}
																																																																																																																																										});
																																																																																																																																									}
																																																																																																																																								};
																																																																																																																																								_timer.schedule(t, (int)(200));
																																																																																																																																							}
																																																																																																																																						});
																																																																																																																																					}
																																																																																																																																				};
																																																																																																																																				_timer.schedule(t, (int)(200));
																																																																																																																																			}
																																																																																																																																		});
																																																																																																																																	}
																																																																																																																																};
																																																																																																																																_timer.schedule(t, (int)(200));
																																																																																																																															}
																																																																																																																														});
																																																																																																																													}
																																																																																																																												};
																																																																																																																												_timer.schedule(t, (int)(200));
																																																																																																																											}
																																																																																																																										});
																																																																																																																									}
																																																																																																																								};
																																																																																																																								_timer.schedule(t, (int)(200));
																																																																																																																							}
																																																																																																																						});
																																																																																																																					}
																																																																																																																				};
																																																																																																																				_timer.schedule(t, (int)(200));
																																																																																																																			}
																																																																																																																		});
																																																																																																																	}
																																																																																																																};
																																																																																																																_timer.schedule(t, (int)(200));
																																																																																																															}
																																																																																																														});
																																																																																																													}
																																																																																																												};
																																																																																																												_timer.schedule(t, (int)(200));
																																																																																																											}
																																																																																																										});
																																																																																																									}
																																																																																																								};
																																																																																																								_timer.schedule(t, (int)(200));
																																																																																																							}
																																																																																																						});
																																																																																																					}
																																																																																																				};
																																																																																																				_timer.schedule(t, (int)(200));
																																																																																																			}
																																																																																																		});
																																																																																																	}
																																																																																																};
																																																																																																_timer.schedule(t, (int)(200));
																																																																																															}
																																																																																														});
																																																																																													}
																																																																																												};
																																																																																												_timer.schedule(t, (int)(200));
																																																																																											}
																																																																																										});
																																																																																									}
																																																																																								};
																																																																																								_timer.schedule(t, (int)(200));
																																																																																							}
																																																																																						});
																																																																																					}
																																																																																				};
																																																																																				_timer.schedule(t, (int)(200));
																																																																																			}
																																																																																		});
																																																																																	}
																																																																																};
																																																																																_timer.schedule(t, (int)(200));
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(200));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(200));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(200));
																																																																				_setFlashEnabled(true);
																																																																				t = new TimerTask() {
																																																																					@Override
																																																																					public void run() {
																																																																						runOnUiThread(new Runnable() {
																																																																							@Override
																																																																							public void run() {
																																																																								_setFlashEnabled(false);
																																																																								t = new TimerTask() {
																																																																									@Override
																																																																									public void run() {
																																																																										runOnUiThread(new Runnable() {
																																																																											@Override
																																																																											public void run() {
																																																																												_setFlashEnabled(true);
																																																																												t = new TimerTask() {
																																																																													@Override
																																																																													public void run() {
																																																																														runOnUiThread(new Runnable() {
																																																																															@Override
																																																																															public void run() {
																																																																																_setFlashEnabled(false);
																																																																															}
																																																																														});
																																																																													}
																																																																												};
																																																																												_timer.schedule(t, (int)(50));
																																																																											}
																																																																										});
																																																																									}
																																																																								};
																																																																								_timer.schedule(t, (int)(50));
																																																																							}
																																																																						});
																																																																					}
																																																																				};
																																																																				_timer.schedule(t, (int)(50));
																																																																			}
																																																																		});
																																																																	}
																																																																};
																																																																_timer.schedule(t, (int)(50));
																																																															}
																																																														});
																																																													}
																																																												};
																																																												_timer.schedule(t, (int)(50));
																																																											}
																																																										});
																																																									}
																																																								};
																																																								_timer.schedule(t, (int)(50));
																																																							}
																																																						});
																																																					}
																																																				};
																																																				_timer.schedule(t, (int)(50));
																																																			}
																																																		});
																																																	}
																																																};
																																																_timer.schedule(t, (int)(50));
																																															}
																																														});
																																													}
																																												};
																																												_timer.schedule(t, (int)(50));
																																											}
																																										});
																																									}
																																								};
																																								_timer.schedule(t, (int)(50));
																																							}
																																						});
																																					}
																																				};
																																				_timer.schedule(t, (int)(50));
																																			}
																																		});
																																	}
																																};
																																_timer.schedule(t, (int)(50));
																															}
																														});
																													}
																												};
																												_timer.schedule(t, (int)(50));
																											}
																										});
																									}
																								};
																								_timer.schedule(t, (int)(50));
																							}
																						});
																					}
																				};
																				_timer.schedule(t, (int)(50));
																			}
																		});
																	}
																};
																_timer.schedule(t, (int)(50));
															}
														});
													}
												};
												_timer.schedule(t, (int)(50));
											}
										});
									}
								};
								_timer.schedule(t, (int)(50));
							}
						});
					}
				};
				_timer.schedule(t, (int)(50));
			}
		});
	}
	
	private void initializeLogic() {
		sound = new SoundPool((int)(1), AudioManager.STREAM_MUSIC, 0);
		sounduz = sound.load(getApplicationContext(), R.raw.onsound, 1);
		linear9.setVisibility(View.GONE);
		linear10.setVisibility(View.GONE);
		BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
		int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
		textview1.setText(Integer.toString(batLevel));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFF333333));
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
					Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);}
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN); if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { getWindow().setStatusBarColor(Color.TRANSPARENT); }
	}
	
	public void _setFlashEnabled(final boolean _b) {
		if (_b) {
			android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
			try {
				String cameraId = cameraManager.getCameraIdList()[0]; cameraManager.setTorchMode(cameraId, true);
				flashLightStatus = true; } catch (android.hardware.camera2.CameraAccessException e) { }
		}
		else {
			android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
			try {
				String cameraId = cameraManager.getCameraIdList()[0]; cameraManager.setTorchMode(cameraId, false);
				flashLightStatus = false;} catch (android.hardware.camera2.CameraAccessException e) { }
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}