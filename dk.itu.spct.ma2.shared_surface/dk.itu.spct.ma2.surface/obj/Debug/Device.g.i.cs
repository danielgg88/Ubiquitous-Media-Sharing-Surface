﻿#pragma checksum "..\..\Device.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "95E17F697F118DCFA78C1108BDF45FFA"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.18444
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Surface.Presentation.Controls;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace TaggingLabClass {
    
    
    /// <summary>
    /// Device
    /// </summary>
    public partial class Device : Microsoft.Surface.Presentation.Controls.TagVisualization, System.Windows.Markup.IComponentConnector {
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/dk.itu.spct.ma2.surface;component/device.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Device.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            
            #line 13 "..\..\Device.xaml"
            ((System.Windows.Controls.Grid)(target)).PreviewDrop += new System.Windows.DragEventHandler(this.OnVisualizationDrop);
            
            #line default
            #line hidden
            
            #line 14 "..\..\Device.xaml"
            ((System.Windows.Controls.Grid)(target)).PreviewDragEnter += new System.Windows.DragEventHandler(this.OnVisualizationEnter);
            
            #line default
            #line hidden
            
            #line 15 "..\..\Device.xaml"
            ((System.Windows.Controls.Grid)(target)).Drop += new System.Windows.DragEventHandler(this.Grid_PreviewGiveFeedback);
            
            #line default
            #line hidden
            return;
            case 2:
            
            #line 24 "..\..\Device.xaml"
            ((Microsoft.Surface.Presentation.Controls.SurfaceButton)(target)).Click += new System.Windows.RoutedEventHandler(this.OnPinButtonClicked);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

