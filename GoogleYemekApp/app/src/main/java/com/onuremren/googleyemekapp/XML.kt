//package com.onuremren.googleyemekapp
//
//
//<!--
//~ Copyright (C) 2021 The Android Open Source Project.
//~
//~ Licensed under the Apache License, Version 2.0 (the "License");
//~ you may not use this file except in compliance with the License.
//~ You may obtain a copy of the License at
//~
//~     http://www.apache.org/licenses/LICENSE-2.0
//~
//~ Unless required by applicable law or agreed to in writing, software
//~ distributed under the License is distributed on an "AS IS" BASIS,
//~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//~ See the License for the specific language governing permissions and
//~ limitations under the License.
//-->
//<layout
//xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:tools="http://schemas.android.com/tools"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//tools:context=".ui.order.EntreeMenuFragment">
//
//<data>
//<variable
//name="viewModel"
//type="com.onuremren.googleyemekapp.model.TuesdayViewModel" />
//
//<!-- TODO: Add the data binding variable for the EntreeMenuFragment -->
//<variable
//name="wednesdayMainCourseMenuFragment"
//type="com.onuremren.googleyemekapp.wednesdayUi.WednesdayFragment" />
//</data>
//
//
//<ScrollView
//android:layout_width="match_parent"
//android:layout_height="wrap_content">
//
//<androidx.constraintlayout.widget.ConstraintLayout
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:paddingStart="@dimen/side_margin"
//android:paddingEnd="@dimen/side_margin"
//android:paddingBottom="@dimen/side_margin">
//
//<RadioGroup
//android:id="@+id/entree_options"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:orientation="vertical"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent">
//
//<!-- TODO: set the entree in the view model when the RadioButton is clicked -->
//<RadioButton
//android:id="@+id/cauliflower"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textAppearance="?attr/textAppearanceBody1"
//android:text='@{viewModel.tuesdayMenuItem["Kuru Fasülye"].name}'
//android:onClick='@{() -> viewModel.setEntree("Kuru Fasülye")}'
//tools:text="Entree 1" />
//
//<LinearLayout android:id="@+id/addMoreLayout1"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:visibility="gone"
//android:layout_margin="10dp"
//android:orientation="horizontal">
//
//<ImageView android:id="@+id/imageMinus1"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.minusminus()}"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_remove"
//app:tint="@color/purple_700"
///>
//
//
//<TextView android:id="@+id/tvCount1"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textSize="16sp"
//android:layout_marginStart="05dp"
//android:layout_marginEnd="05dp"
//android:textColor="@color/black"
//android:text="1"
//android:gravity="center_horizontal"
///>
//
//<ImageView android:id="@+id/imageAddOne1"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.plusplus()}"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_add"
//app:tint="@color/purple_700"
///>
//
//
//</LinearLayout>
//
//<TextView
//android:id="@+id/cauliflower_description"
//style="@style/Widget.MenuItem.TextView.Info"
//android:text='@{viewModel.tuesdayMenuItem["Kuru Fasülye"].description}'
//tools:text="Entree 1 description" />
//
//<TextView
//android:id="@+id/cauliflower_price"
//style="@style/Widget.MenuItem.TextView.Info"
//android:paddingTop="@dimen/base_margin"
//android:text='@{viewModel.tuesdayMenuItem["Kuru Fasülye"].getFormattedPrice()}'
//tools:text="$0.00" />
//
//<View
//style="@style/Widget.LunchTray.Divider"
//android:layout_width="match_parent"
//android:layout_height="1dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@id/cauliflower_description" />
//
//<!-- TODO: set the entree in the view model when the RadioButton is clicked -->
//<RadioButton
//android:id="@+id/chili"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textAppearance="?attr/textAppearanceBody1"
//android:text='@{viewModel.tuesdayMenuItem["Taze Fasülye"].name}'
//android:onClick='@{() -> viewModel.setEntree("Taze Fasülye")}'
//tools:text="Entree 2" />
//
//<LinearLayout android:id="@+id/addMoreLayout2"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:visibility="gone"
//android:layout_margin="10dp"
//android:orientation="horizontal">
//
//<ImageView android:id="@+id/imageMinus2"
//android:layout_width="30dp"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.minusFasulye()}"
//android:layout_height="30dp"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_remove"
//app:tint="@color/purple_700"
///>
//
//
//<TextView android:id="@+id/tvCount2"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textSize="16sp"
//android:layout_marginStart="05dp"
//android:layout_marginEnd="05dp"
//android:textColor="@color/black"
//android:text="1"
//android:gravity="center_horizontal"
///>
//
//<ImageView android:id="@+id/imageAddOne2"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.plusFasulye()}"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_add"
//app:tint="@color/purple_700"
///>
//
//
//</LinearLayout>
//<TextView
//android:id="@+id/chili_description"
//style="@style/Widget.MenuItem.TextView.Info"
//android:text='@{viewModel.tuesdayMenuItem["Taze Fasülye"].description}'
//tools:text="Entree 2 description" />
//
//<TextView
//android:id="@+id/chili_price"
//style="@style/Widget.MenuItem.TextView.Info"
//android:paddingTop="@dimen/base_margin"
//android:text='@{viewModel.tuesdayMenuItem["Taze Fasülye"].getFormattedPrice()}'
//tools:text="$0.00" />
//
//<View
//style="@style/Widget.LunchTray.Divider"
//android:layout_width="match_parent"
//android:layout_height="1dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@id/chili_description" />
//
//<!-- TODO: set the entree in the view model when the RadioButton is clicked -->
//<RadioButton
//android:id="@+id/pasta"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textAppearance="?attr/textAppearanceBody1"
//android:text='@{viewModel.tuesdayMenuItem["Kıymalı Patates"].name}'
//android:onClick='@{() -> viewModel.setEntree("Kıymalı Patates")}'
//tools:text="Entree 3" />
//
//<LinearLayout
//android:id="@+id/addMoreLayout3"
//android:layout_width="wrap_content"
//android:layout_height="23dp"
//android:layout_margin="10dp"
//android:orientation="horizontal"
//android:visibility="gone">
//
//<ImageView
//android:id="@+id/imageMinus3"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_remove"
//app:tint="@color/purple_700" />
//
//
//<TextView
//android:id="@+id/tvCount3"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginStart="05dp"
//android:layout_marginEnd="05dp"
//android:gravity="center_horizontal"
//android:text="1"
//android:textColor="@color/black"
//android:textSize="16sp" />
//
//<ImageView
//android:id="@+id/imageAddOne3"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:layout_gravity="center_horizontal"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.plusplus()}"
//android:src="@drawable/ic_baseline_add"
//app:tint="@color/purple_700" />
//
//
//</LinearLayout>
//<TextView
//android:id="@+id/pasta_description"
//style="@style/Widget.MenuItem.TextView.Info"
//android:text='@{viewModel.tuesdayMenuItem["Kıymalı Patates"].description}'
//tools:text="Entree 3 description" />
//
//<TextView
//android:id="@+id/pasta_price"
//style="@style/Widget.MenuItem.TextView.Info"
//android:paddingTop="@dimen/base_margin"
//android:text='@{viewModel.tuesdayMenuItem["Kıymalı Patates"].getFormattedPrice()}'
//tools:text="$0.00" />
//
//<View
//style="@style/Widget.LunchTray.Divider"
//android:layout_width="match_parent"
//android:layout_height="1dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@id/pasta_description" />
//
//<!-- TODO: set the entree in the view model when the RadioButton is clicked -->
//<RadioButton
//android:id="@+id/skillet"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textAppearance="?attr/textAppearanceBody1"
//android:text='@{viewModel.tuesdayMenuItem["izmirKöfte"].name}'
//android:onClick='@{() -> viewModel.setEntree("izmirKöfte")}'
//tools:text="Entree 4" />
//
//<LinearLayout android:id="@+id/addMoreLayout4"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:visibility="gone"
//android:layout_margin="10dp"
//android:orientation="horizontal">
//
//<ImageView android:id="@+id/imageMinus4"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_remove"
//app:tint="@color/purple_700"
///>
//
//
//<TextView android:id="@+id/tvCount4"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:textSize="16sp"
//android:layout_marginStart="05dp"
//android:layout_marginEnd="05dp"
//android:textColor="@color/black"
//android:text="1"
//android:gravity="center_horizontal"
///>
//
//<ImageView android:id="@+id/imageAddOne4"
//android:layout_width="30dp"
//android:layout_height="30dp"
//android:layout_gravity="center_horizontal"
//android:src="@drawable/ic_baseline_add"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.plusplus()}"
//app:tint="@color/purple_700"
///>
//
//
//</LinearLayout>
//<TextView
//android:id="@+id/skillet_description"
//style="@style/Widget.MenuItem.TextView.Info"
//android:text='@{viewModel.tuesdayMenuItem["izmirKöfte"].description}'
//tools:text="Entree 4 description" />
//
//<TextView
//android:id="@+id/skillet_price"
//style="@style/Widget.MenuItem.TextView.Info"
//android:paddingTop="@dimen/base_margin"
//android:text='@{viewModel.tuesdayMenuItem["izmirKöfte"].getFormattedPrice()}'
//tools:text="$0.00" />
//
//</RadioGroup>
//
//<View
//android:id="@+id/divider"
//style="@style/Widget.LunchTray.Divider"
//android:layout_width="match_parent"
//android:layout_height="1dp"
//android:layout_marginTop="@dimen/base_margin"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@id/entree_options" />
//
//<!-- TODO: set the text to the current subtotal value from the view model -->
//<TextView
//android:id="@+id/subtotal"
//style="@style/Widget.LunchTray.TextView.Subtotal"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintTop_toBottomOf="@id/divider"
//tools:text="Subtotal $5.00"
//android:text="@{@string/subtotal(viewModel.subtotal)}"
///>
//
//<!-- TODO: cancel the order when clicked -->
//<Button
//android:id="@+id/cancel_button"
//style="@style/Widget.Order.Button.Cancel"
//app:layout_constraintEnd_toStartOf="@id/next_button"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="@id/next_button"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.cancelOrder()}"
///>
//
//<!-- TODO: go to the next screen when clicked -->
//<Button
//android:id="@+id/next_button"
//style="@style/Widget.Order.Button.Next"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toEndOf="@id/cancel_button"
//app:layout_constraintTop_toBottomOf="@id/subtotal"
//android:onClick="@{() -> wednesdayMainCourseMenuFragment.goToNextScreen()}"
///>
//
//</androidx.constraintlayout.widget.ConstraintLayout>
//</ScrollView>
//</layout>